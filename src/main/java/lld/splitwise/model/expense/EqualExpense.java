package lld.splitwise.model.expense;


import lld.splitwise.model.User;
import lld.splitwise.model.split.EqualSplit;
import lld.splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(double amount, User expensePaidBy, List<Split> splits) {
        super(amount, expensePaidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)) return false;
        }
        return true;
    }


}
