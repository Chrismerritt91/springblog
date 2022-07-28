package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model vModel){

        List<Post> postList = new ArrayList<>(Arrays.asList(
                new Post(1,"post1", "hjdshnjdshnjeswbnecdxhj ecxhb nikfcexhjbwsndixnscuyhbuvincuebd"),
                new Post(2,"post2", "ghfjdsbncxbncdxyuirebunirffce cxhjirecbxunfcd"),
                new Post(3,"post3", "unficdxwbuniefcdwshujefcdbxhjncexhbnj fydeuncfhrfbecnxw")
        ));

        vModel.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String findPost(@PathVariable long id, Model vModel){

        Post post = new Post(id,
                "post " + id,
                "hjdshnjdshnjeswbnecdxhj ecxhb nikfcexhjbwsndixnscuyhbuvincuebd");

                vModel.addAttribute("post", post);

        return "posts/show";
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
