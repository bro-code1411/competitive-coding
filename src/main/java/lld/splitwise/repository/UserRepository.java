package lld.splitwise.repository;

import lld.splitwise.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository userRepository;

    Map<String, User> userMap;

    private UserRepository() {
        userMap = new HashMap();
    }

    // Only one thread can execute this at a time
    public static synchronized UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }


    public boolean addUser(User user) {
        if(userMap.containsKey(user.getUserName())){
            return false;
        }
        userMap.put(user.getUserName(), user);
        return true;
    }

    public User getUser(String userName) {
        return userMap.getOrDefault(userName, null);
    }


}
