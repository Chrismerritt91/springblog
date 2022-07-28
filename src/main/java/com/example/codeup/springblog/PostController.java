package com.example.codeup.springblog;

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
                new Post("post1", "hjdshnjdshnjeswbnecdxhj ecxhb nikfcexhjbwsndixnscuyhbuvincuebd"),
                new Post("post2", "ghfjdsbncxbncdxyuirebunirffce cxhjirecbxunfcd"),
                new Post("post3", "unficdxwbuniefcdwshujefcdbxhjncexhbnj fydeuncfhrfbecnxw")
        ));

        vModel.addAttribute("Posts", postList);

        return "posts/index";
    }

    @PostMapping("/posts")
    public String findPost(@RequestParam String title, Model vModel){

        List<Post> postList = new ArrayList<>(Arrays.asList(
                new Post("post1", "hjdshnjdshnjeswbnecdxhj ecxhb nikfcexhjbwsndixnscuyhbuvincuebd"),
                new Post("post2", "ghfjdsbncxbncdxyuirebunirffce cxhjirecbxunfcd"),
                new Post("post3", "unficdxwbuniefcdwshujefcdbxhjncexhbnj fydeuncfhrfbecnxw")
        ));

        for(Post post: postList){
            if(post.getTitle().equals(title)){
                vModel.addAttribute("post", post);
            }
        }

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
