package lld.splitwise.service;

import lld.splitwise.model.User;
import lld.splitwise.repository.UserRepository;

public interface UserService {

    public boolean addUser(User user);

    public User getUser(String userName);
}
