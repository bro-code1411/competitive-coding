package lld.splitwise.service;


import lld.splitwise.model.User;
import lld.splitwise.repository.UserRepository;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(){
        this.userRepository =  UserRepository.getInstance();
    }

    public boolean addUser(User user){
        return userRepository.addUser(user);
    }
    public User getUser(String userName){
        return userRepository.getUser(userName);
    }
}
