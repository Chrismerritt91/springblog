package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "this is the index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String findPost(@PathVariable long id){
        return "returns the post that corresponds with id number:" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createId(){
        return "this page is for creating adds.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "this page sends the create information to the dataBase.";
    }

}
