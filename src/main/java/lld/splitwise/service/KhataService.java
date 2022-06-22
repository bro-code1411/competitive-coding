package lld.splitwise.service;

import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.User;
import lld.splitwise.model.split.Split;

import java.util.List;

public interface KhataService {

    public boolean initializeBalanceSheet(User user);

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits);

    public List<String> getBalance(String userName);

    public List<String> getBalances();

}
