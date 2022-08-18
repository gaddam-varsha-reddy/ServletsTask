package com.demo.interfaceManager;
import com.demo.model.User;
import java.util.List;
public interface UserManager {
    void addUser(User user);
    List<User> listUsers();
    void deleteUser(String s);
    List<User> searchUsers(String firstName);
    void updateUser(User user);
}
