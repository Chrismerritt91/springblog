package com.example.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Establishes that this class is a controller
@Controller
public class HelloController {
// Establishes that this is the url pattern we are looking for (specifically for get request)
    @GetMapping("/hello")
    // establishes what the body of the response will be
    @ResponseBody
    // defines what the response body will be
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "This is just a test.";
    }

//    @GetMapping("/increment/{number}")
//    @ResponseBody
//    public String increment(@PathVariable int number){
//        return number + " plus one = " + (number + 1) + "!";
//    }

    @RequestMapping(path ="/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String increment(@PathVariable int number){
        return number + " plus one = " + (number + 1) + "!";
    }
}
