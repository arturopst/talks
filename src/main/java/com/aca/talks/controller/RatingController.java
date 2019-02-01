package com.aca.talks.controller;

import com.aca.talks.domain.Rating;
import com.aca.talks.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @RequestMapping("/")
    public String GetAll(Model model) {
        List<Rating> ratingsList = ratingService.getAll();
        model.addAttribute("ratings", ratingsList);
        return "ratings";
    }



    @RequestMapping("/getRating")
    public String GetRating(Long id, Model model) {
        Rating rating = ratingService.getById(id);
            model.addAttribute("rating", rating);
            return "rating";
    }
    @RequestMapping("/saveRating")
    public String saveRating(Rating rating, Model model) {
        try {
            ratingService.save(rating);
        }catch(Exception ex){
            System.out.println("Error saving rating:"+ ex.getMessage());
        }
        model.addAttribute("rating", rating);
        return "rating";
    }


}
