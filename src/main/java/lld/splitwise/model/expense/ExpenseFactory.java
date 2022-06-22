package lld.splitwise.model.expense;

import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.User;
import lld.splitwise.model.split.Split;

import java.util.List;

public class ExpenseFactory {

    public Expense createExpense(ExpenseType expenseType, double amount, User expensePaidBy, List<Split> splits)
            throws IllegalArgumentException {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, expensePaidBy, splits);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount * 100 / totalSplits)) / 100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                return new EqualExpense(amount, expensePaidBy, splits);
            default:
                throw new IllegalArgumentException("Expense type invalid");
        }
    }
}
