package foodkart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private Restaurant restaurant;
    private User user;
    private Map<String,Integer> itemToQuantityMap = new HashMap<>();

    public Order(Restaurant restaurant, User user, Map<String, Integer> itemToQuantityMap) {
        this.restaurant = restaurant;
        this.user = user;
        this.itemToQuantityMap = itemToQuantityMap;
    }

    @Override
    public String toString() {
        return "Order{" +
                "restaurant=" + restaurant +
                ", user=" + user +
                ", itemToQuantityMap=" + itemToQuantityMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(restaurant, order.restaurant) &&
                Objects.equals(user, order.user) &&
                Objects.equals(itemToQuantityMap, order.itemToQuantityMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant, user, itemToQuantityMap);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Integer> getItemToQuantityMap() {
        return itemToQuantityMap;
    }

    public void setItemToQuantityMap(Map<String, Integer> itemToQuantityMap) {
        this.itemToQuantityMap = itemToQuantityMap;
    }
}
