package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/firstview")
    public String runFirstView(Model vModel){
        vModel.addAttribute("name", "Chris");
        return "first-view";
    }

    @GetMapping("/favcity")
    public String favoriteCity(){
        return "fav-city";
    }

    @PostMapping("/favcity")
    public String returnCity(@RequestParam String city, Model vModel){
        vModel.addAttribute("city", city);
//        return "favcity-result";
        return "redirect://www.pexels.com/search/"+ city +"/";
    }
}
