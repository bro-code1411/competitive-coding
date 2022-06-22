package lld.splitwise.model.split;

import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.User;

public class SplitFactory {
    public Split createSplit(ExpenseType type, User user, Double amount) throws IllegalArgumentException {
        if (type == null) {
            return null;
        }
        if(user== null){
            throw new IllegalArgumentException("Unknown User.");
        }
        switch (type) {
            case EQUAL:
                return new EqualSplit(user);
            case EXACT:
                return new ExactSplit(user, amount);
            default:
                throw new IllegalArgumentException("Unknown ExpenseType.");
        }

    }
}
