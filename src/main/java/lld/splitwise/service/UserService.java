package lld.splitwise.service;


import lld.splitwise.model.User;
import lld.splitwise.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public UserService(){
        this.userRepository =  UserRepository.getInstance();
    }

    public boolean addUser(User user){
        return userRepository.addUser(user);
    }
    public User getUser(String userName){
        return userRepository.getUser(userName);
    }
}
