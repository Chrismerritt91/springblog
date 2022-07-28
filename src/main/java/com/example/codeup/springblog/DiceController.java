package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @GetMapping("/rolldice")
    public String diceRoll(){
        return "roll-dice";
    }

//    @PostMapping("/rolldice")
//    public String diceResult(@RequestParam int roll, Model vModel){
//        int randomNum = (int) ((Math.random() * 6) + 1);
//        String result;
//        if(roll == randomNum){
//            result = "You win the number was " + randomNum;
//        } else{
//            result =  "You lose, you guessed " + roll + " the number was " + randomNum;
//        }
//        vModel.addAttribute("result", result);
//        return "roll-dice";
//    }

    @GetMapping("/rolldice/{guess}")
    public String diceResult(@PathVariable int guess, Model vModel){
        int roll = (int) ((Math.random() * 6) + 1);
        vModel.addAttribute("guess", guess);
        vModel.addAttribute("roll", roll);
        return "roll-result";
    }

}
