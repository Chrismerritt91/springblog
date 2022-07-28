package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
// get all records
    @GetMapping("/posts")
    public String showAllPosts(Model vModel){

        List<Post> postList = postDao.findAll();

        vModel.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String findPost(@PathVariable long id, Model vModel){
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@RequestParam String title, @RequestParam String body){
        Post post = new Post(title, body);
                postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

}
