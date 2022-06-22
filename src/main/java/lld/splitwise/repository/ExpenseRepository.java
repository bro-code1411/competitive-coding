package lld.splitwise.repository;


import lld.splitwise.model.User;
import lld.splitwise.model.expense.Expense;
import lld.splitwise.model.split.Split;
import lld.splitwise.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    List<Expense> expenses;
    Map<String, Map<String, Double>> balanceSheet;
    UserServiceImpl userService;

    private ExpenseRepository() {
        expenses = new ArrayList();
        balanceSheet = new HashMap();
        userService = new UserServiceImpl();
    }

    private static ExpenseRepository expenseRepository;

    public static synchronized ExpenseRepository getInstance()
    {
        if (expenseRepository==null)
            expenseRepository = new ExpenseRepository();
        return expenseRepository;
    }

    public boolean initializeBalanceSheet(User user) {
        if(balanceSheet.containsKey(user.getUserName())){
            return false;
        }
        balanceSheet.put(user.getUserName(), new HashMap<>());
        return true;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        assert expense != null;
        String paidBy = expense.getExpensePaidBy().getUserName();
        for (Split split : expense.getSplits()) {
            String paidTo = split.getUser().getUserName();

            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public List<String> getBalance(String userName) {
        List<String> balances = new ArrayList<>();
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userName).entrySet()) {
            if (userBalance.getValue() != 0) {
                balances.add(checkSign(userName, userBalance.getKey(), userBalance.getValue()));
            }
        }
        return balances;
    }

    public List<String> getBalances() {
        List<String> balances = new ArrayList<>();
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    balances.add(checkSign(allBalances.getKey(), userBalance.getKey(), userBalance.getValue()));
                }
            }
        }
        return balances;
    }

    private String checkSign(String user1, String user2, double amount) {
        String user1Name = userService.getUser(user1).getUserName();
        String user2Name = userService.getUser(user2).getUserName();
        if (amount < 0) {
            return  user1Name + " owes " + user2Name + ": " + Math.abs(amount);
        } else if (amount > 0) {
            return user2Name + " owes " + user1Name + ": " + Math.abs(amount);
        }
        return "";
    }
}
