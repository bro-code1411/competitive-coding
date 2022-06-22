package lld.splitwise.model.expense;

import lld.splitwise.model.User;
import lld.splitwise.model.split.Split;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private final String id;
    private double amount;
    private User expensePaidBy;
    private List<Split> splits;


    public Expense(double amount, User expensePaidBy, List<Split> splits) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getExpensePaidBy() {
        return expensePaidBy;
    }

    public void setExpensePaidBy(User expensePaidBy) {
        this.expensePaidBy = expensePaidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public abstract boolean validate();
}
