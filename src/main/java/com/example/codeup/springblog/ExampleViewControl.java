package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleViewControl {

    @GetMapping("/helloworld")
    public String returnHelloWorld(Model vModel){
//        Model is used to set attributes
        vModel.addAttribute("name", "Chris");
//        like our set attribute in java3
        return "Hello-world";
    }

    @GetMapping("/search")
    public String returnSearchForm(){
        return "search";
    }

    @PostMapping("/search")
//    @Requestparam is the new way of running request.getparameter
    public String returnSearchResults(@RequestParam String query, Model vModel){
        vModel.addAttribute("search", query);
        return "search-results";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(){
        // authenticate user then..
        return "redirect:/";
    }

}
