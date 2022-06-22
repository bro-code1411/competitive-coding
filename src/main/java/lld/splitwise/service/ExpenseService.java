package lld.splitwise.service;

import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.User;
import lld.splitwise.model.expense.*;
import lld.splitwise.model.split.Split;
import lld.splitwise.repository.ExpenseRepository;

import java.util.List;

public class ExpenseService {
    ExpenseRepository expenseRepository = ExpenseRepository.getInstance();
    UserService userService = new UserService();

    public boolean initializeBalanceSheet(User user) {
        return expenseRepository.initializeBalanceSheet(user);
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits) {
        ExpenseFactory expenseFactory = new ExpenseFactory();
        Expense expense = expenseFactory.createExpense(expenseType, amount, userService.getUser(paidBy), splits);
        expenseRepository.addExpense(expense);
    }

    public List<String> getBalance(String userName) {
        return expenseRepository.getBalance(userName);
    }

    public List<String> getBalances() {
return expenseRepository.getBalances();
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
