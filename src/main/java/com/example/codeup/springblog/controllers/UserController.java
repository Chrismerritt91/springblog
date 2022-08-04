package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userDao;
    private PostRepository postDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PostRepository postDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute @Validated User user, Errors validation){
        if(user.getUsername().isEmpty()){
            validation.rejectValue("username", "one", "Username cannot be blank");
        } else if(user.getEmail().isEmpty()){
            validation.rejectValue("email", "one", "email cannot be blank");
        } else if(user.getPassword().isEmpty()){
            validation.rejectValue("password", "one", "Password cannot be blank");
        }
        if(validation.hasErrors()){
            return "users/sign-up";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        User user = userDao.findByUsername(name);
        model.addAttribute("user", user);
        return "users/profile";
    }
}
