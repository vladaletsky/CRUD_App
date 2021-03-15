package com.wladyslaw.crudApp.service;

import com.wladyslaw.crudApp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(int id);
    User findById(int id);
    User searchUser(String name);
}
