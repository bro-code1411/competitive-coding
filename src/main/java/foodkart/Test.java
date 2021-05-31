package foodkart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    private static Foodkart foodkart= new Foodkart();

    public static void main(String[]args){

        User u1 = foodkart.registerUser("Lakshya",97973,201013);
        User u2 = foodkart.registerUser("Sharma",9797233,201001);

        Restaurant res = foodkart.registerRestaurant("Res1", Arrays.asList(201013,201001),"item1",20,2);
        Restaurant res2 = foodkart.registerRestaurant("Res2", Arrays.asList(201001),"item2",20,2);

        Map<String, Integer> itemToQuantityMap = new HashMap<>();
        itemToQuantityMap.put("item1",20);
        foodkart.placeOrder(u1,res, itemToQuantityMap);

        foodkart.createReview( u1, res ,2);
        foodkart.createReview( u1, res ,4);
        foodkart.createReview( u1, res2 ,2);

        foodkart.updateQuantityByOwner(res, "item3", 30);
        Map<String, Integer> itemToQuantityMap2 = new HashMap<>();
        itemToQuantityMap2.put("item3",20);
        foodkart.placeOrder(u1,res, itemToQuantityMap2);


    }
}
