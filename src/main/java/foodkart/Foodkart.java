package foodkart;

import java.util.*;

public class Foodkart {

    private HashMap<Restaurant, HashMap<String, Integer>> restaurantToItemQuantityMap = new HashMap<Restaurant, HashMap<String, Integer>>();

    private HashMap<Restaurant, HashMap<String, Integer>> restaurantToItemPriceMap = new HashMap<Restaurant, HashMap<String, Integer>>();

    private Map<Integer, List<Restaurant>> pincodeToRestaurantMap = new HashMap<>();

    private Map<User, List<Order>> userToOrderMap = new HashMap<>();

    private List<User> userList = new ArrayList<>();

    private List<Restaurant> restaurantList = new ArrayList<>();

    private Map<Restaurant, List<Integer>> restaurantToRatingMap = new HashMap<>();

    private static int userCount = 0;

    private static int restaurantCount = 0;

    public Foodkart() {
    }

    public User registerUser(String name, int number, int pincode) {
        User user = new User(userCount, name, number, pincode);
        if (userList.contains(user)) {
            return null;
        }
        userList.add(user);
        userCount++;
        return user;
    }

    public Restaurant registerRestaurant(String name, List<Integer> pincodeList, String itemName, int price, int quantity) {
        Restaurant restaurant = new Restaurant(restaurantCount, name, pincodeList);
        if (restaurantList.contains(restaurant)) {
            return null;
        }
        HashMap<String, Integer> itemToQuantityMap = new HashMap<String, Integer>();
        itemToQuantityMap.put(itemName, quantity);
        restaurantToItemQuantityMap.put(restaurant, itemToQuantityMap);
        for (Integer pincode : pincodeList) {
            pincodeToRestaurantMap.computeIfAbsent(pincode, k -> new ArrayList<Restaurant>()).add(restaurant);
        }
        HashMap<String, Integer> itemToPriceMap = new HashMap<String, Integer>();
        itemToQuantityMap.put(itemName, price);
        restaurantToItemPriceMap.put(restaurant, itemToPriceMap);
        restaurantToRatingMap.put(restaurant, Arrays.asList(0, 0));
        restaurantCount++;
        System.out.println(name + " " + itemName + " " + price);
        return restaurant;
    }


    public Response placeOrder(User user, Restaurant restaurant, Map<String, Integer> itemToQuantityMap) {

        if (restaurantList.contains(restaurant) && userList.contains(user)) {
            return Response.FAILED;
        }
        if (!checkItemsPresent(restaurant, itemToQuantityMap)) { // Inventory checked
            System.out.println("Order Cannot place order");
            return Response.FAILED;
        }
        updateQuantity(restaurant, itemToQuantityMap);
        Order order = new Order(restaurant, user, itemToQuantityMap);
        userToOrderMap.computeIfAbsent(user, k -> new ArrayList<Order>()).add(order); // Order place

        System.out.println("Order placed");
        return Response.SUCCESS;
    }

    private void updateQuantity(Restaurant restaurant, Map<String, Integer> itemToQuantityMap) {
        HashMap<String, Integer> existingItemToQuantityMap = restaurantToItemQuantityMap.get(restaurant);
        for (Map.Entry<String, Integer> entry : itemToQuantityMap.entrySet()) {
            Integer existingQuantity = existingItemToQuantityMap.get(entry.getKey());
            existingItemToQuantityMap.put(entry.getKey(), existingQuantity - entry.getValue());
        }

    }

    private boolean checkItemsPresent(Restaurant restaurant, Map<String, Integer> itemToQuantityMap) {
        boolean result = false;
        HashMap<String, Integer> existingItemToQuantityMap = restaurantToItemQuantityMap.get(restaurant);
        for (Map.Entry<String, Integer> entry : itemToQuantityMap.entrySet()) {
            if (existingItemToQuantityMap.containsKey(entry.getKey()) && existingItemToQuantityMap.get(entry.getKey()) >= entry.getValue()) {
                result = true;
            }
        }
        return result;
    }

    public void updateQuantityByOwner(Restaurant restaurant, String name, Integer quantity) {
        if(restaurantToItemQuantityMap.get(restaurant).containsKey(name)) {
            Integer existingQuantity = restaurantToItemQuantityMap.get(restaurant).get(name);

            restaurantToItemQuantityMap.get(restaurant).put(name, quantity + existingQuantity);
        }
        else{
            restaurantToItemQuantityMap.get(restaurant).put(name, quantity );
        }
        System.out.println("Updated Quantity" +name);


    }

    public void createReview(User user, Restaurant restaurant, int rating) {
        if (userToOrderMap.containsKey(user) && userToOrderMap.get(user).stream().anyMatch(order -> order.getRestaurant().equals(restaurant))) {
            Integer exsistingRating = restaurantToRatingMap.get(restaurant).get(0);
            Integer quantity = restaurantToRatingMap.get(restaurant).get(1);
            Integer newRating = (exsistingRating * quantity + rating) /( quantity + 1);
            System.out.println("Review:"+ newRating);
            restaurantToRatingMap.put(restaurant, Arrays.asList(newRating, quantity));
        } else {
            System.out.println("Cant review");
        }
    }

    public List<Order> orderHistory(User user) {
        return userToOrderMap.get(user);
    }

    private void showRestaurantPerRating(User user) {
        List<Restaurant> restaurantList = pincodeToRestaurantMap.get(user.getPincode());
        if(restaurantList.isEmpty()){
            System.out.println("No restaurants");
        }
    }

}
