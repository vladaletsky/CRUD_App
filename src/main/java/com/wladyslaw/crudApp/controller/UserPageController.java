package com.wladyslaw.crudApp.controller;

import com.wladyslaw.crudApp.model.User;
import com.wladyslaw.crudApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserPageController {

    private final UserService userService;

    @GetMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/add-user-page")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit-user-page/{id}")
    public String editUserPage(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit-user")
    public String editUser(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String userSearch(@RequestParam String firstName, Model model) {
        model.addAttribute("users", userService.searchUser(firstName));
        return "index";
    }

}
