package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private UserRepository userDao;

    // two ways for dependency injections

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    // get all records
    @GetMapping("/posts")
    public String showAllPosts(Model vModel) {

        List<Post> postList = postDao.findAll();

        vModel.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String findPost(@PathVariable long id, Model vModel) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("posts", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String submitEditPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }
}
