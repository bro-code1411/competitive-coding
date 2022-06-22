package lld.splitwise;

import lld.splitwise.model.ExpenseType;
import lld.splitwise.model.Operation;
import lld.splitwise.model.User;
import lld.splitwise.model.split.Split;
import lld.splitwise.model.split.SplitFactory;
import lld.splitwise.service.SplitWiseService;
import lld.splitwise.service.UserServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Input Sample Users
        User user1 = new User(1, "u1", "u1@gmail.com", "9890098900");
        User user2 = new User(2, "u2", "u2@gmail.com", "9999999999");
        User user3 = new User(3, "u3", "u3@gmail.com", "9898989899");
        User user4 = new User(4, "u4", "u4@gmail.com", "8976478292");
//SHOW
//SHOW u1
//EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
//SHOW u4
//SHOW u1
//EXPENSE u1 1250 2 u2 u3 EXACT 370 880
//SHOW
//EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//SHOW u1
//SHOW
        // Adding Expenses
        SplitWiseService service = new SplitWiseService();
        try {
            service.initializeUser(user1);
            service.initializeUser(user2);
            service.initializeUser(user3);
            service.initializeUser(user4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        UserServiceImpl userService = new UserServiceImpl();
        SplitFactory splitFactory = new SplitFactory();

        while (true) {
            Scanner scan = new Scanner(System.in);
            String[] commands = scan.nextLine().split(" ");
            Operation operation = Operation.valueOf(commands[0]);
            switch (operation) {
                case EXPENSE:
                    String userName = commands[1];
                    double amountSpend = Double.parseDouble(commands[2]);
                    int totalMembers = Integer.parseInt(commands[3]);
                    List<Split> splits = new ArrayList<>();
                    int expenseIndex = 3 + totalMembers + 1;
                    try {
                        ExpenseType expense = ExpenseType.valueOf(commands[expenseIndex]);

                        for (int i = 0; i < totalMembers; i++) {
                            double amount = 0;
                            if (commands.length > expenseIndex + i + 1) {
                                amount = Double.parseDouble(commands[expenseIndex + i + 1]);
                            }
                            User user = userService.getUser(commands[4 + i]);
                            splits.add(splitFactory.createSplit(expense, user, amount));
                        }
                        service.addExpense(expense, amountSpend, userName, splits);
                        System.out.println("OK");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case SHOW:
                    if (commands.length == 1)
                        service.showBalances();
                    else
                        service.showBalance(commands[1]);
                    break;
                case QUIT:
                    System.out.println("Thanks for using splitwise...");
                    return;
                default:
                    System.out.println("Enter a valid argument");
                    break;
            }

        }
    }
}
