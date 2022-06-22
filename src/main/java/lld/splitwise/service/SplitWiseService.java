package lld.splitwise.service;


import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.User;
import lld.splitwise.model.split.Split;

import java.util.List;

public class SplitWiseService {
    ExpenseService expenseService;
    UserService userService;

    public SplitWiseService() {
        this.expenseService = new ExpenseService();
        this.userService = new UserService();
    }

    public boolean initializeUser (User user)throws  IllegalArgumentException {
        boolean userCreated = userService.addUser(user);
        boolean usersBookAdded = expenseService.initializeBalanceSheet(user);
        if(!userCreated && !usersBookAdded){
            throw new IllegalArgumentException("User already present");
        }
        return true;
    }

    public void addExpense(ExpenseType expenseType, double amount,
                           String expensePaidBy, List<Split> splits) {
        expenseService.addExpense(expenseType, amount, expensePaidBy, splits);
    }

    public void showBalance(String userName) {
        List<String> balances = expenseService.getBalance(userName);
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for (String balance : balances) {
                System.out.println(balance);
            }
        }
    }


    public void showBalances() {
        List<String> balances = expenseService.getBalances();
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for (String balance : balances) {
                System.out.println(balance);
            }
        }
    }
}
