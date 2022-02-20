package com.example.movies2.controller;

import com.example.movies2.repositories.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class MovieController {

    MovieRepository mv = new MovieRepository();

    @GetMapping("/")
    public String velkomst(){

        return "welcomeMessage";
    }

    @GetMapping("/all")

    public String findall(Model model){

        model.addAttribute("movieHeader", "List of all movies!");
        model.addAttribute("movieList", mv.findall());

        return "movieList";


    }

    @GetMapping("/first")
    public String getFirst(Model model){
        model.addAttribute("firstMovie", "First movie on the list!");
        model.addAttribute("movie", mv.getFirst());

        return "firstMovie";
    }

    @GetMapping("/random")
    public String getRandom(Model model){

        model.addAttribute("randoMovie", "Random movie for you!");
        model.addAttribute("rando", mv.getRandom());


        return "randomMovie";
    }

    @GetMapping("/pop")
    public String getTenSortByPop(Model model){
        model.addAttribute("topTenMovie", "Top ten random movie list. Just for you!");
        model.addAttribute("randoTen", mv.topTenPop());
        return "randomTopTen";
    }

    @GetMapping("/award")
    public String award(Model model){

        model.addAttribute("AwardWinner", "Thes movies have won an award at some point!");
        model.addAttribute("Awards", mv.awardWinners());


        return "awardWinners";
    }


}
