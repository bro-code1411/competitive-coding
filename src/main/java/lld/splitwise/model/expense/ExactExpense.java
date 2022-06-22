package lld.splitwise.model.expense;

import lld.splitwise.model.User;
import lld.splitwise.model.split.ExactSplit;
import lld.splitwise.model.split.Split;

import java.util.List;


public class ExactExpense extends Expense {

    public ExactExpense(double amount, User expensePaidBy, List<Split> splits) {
        super(amount, expensePaidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double totalSplitAmount = 0;
        for(Split split: getSplits()){
            if(!(split instanceof ExactSplit)) return false;
            ExactSplit exactSplit = (ExactSplit) split;
            totalSplitAmount+=exactSplit.getAmount();
        }
        return totalAmount == totalSplitAmount;
    }
}
