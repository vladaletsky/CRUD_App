package com.wladyslaw.crudApp.service.impl;

import com.wladyslaw.crudApp.model.User;
import com.wladyslaw.crudApp.repository.UserRepository;
import com.wladyslaw.crudApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User searchUser(String name) {
        return userRepository.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(name, name);
    }

    @Override
    public void editUser(User user) {
        User myUser = userRepository.findById(user.getId()).get();
        myUser.setFirstName(user.getFirstName());
        myUser.setLastName(user.getLastName());
        myUser.setAge(user.getAge());
        userRepository.save(myUser);
    }


}
