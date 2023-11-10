package com.moengage.assignment.controller;

import com.moengage.assignment.model.Brewery;
import com.moengage.assignment.model.Review;
import com.moengage.assignment.model.UserModel;
import com.moengage.assignment.repository.BreweryRepository;
import com.moengage.assignment.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    private BreweryRepository breweryRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    @GetMapping("/search")
    public String getRegisterPage(@RequestParam(name = "searchType") String searchType,
                                  @RequestParam(name = "value") String searchText,
                                  Model model) {
        List<Brewery> searchResults = null;
        if(searchType==null||searchText==null)
            return "error_page";
        if(searchType.equals("city"))
            searchResults=breweryRepository.findByCity(searchText);
        else if(searchType.equals("name"))
            searchResults=breweryRepository.findByName(searchText);
        else if(searchType.equals("type"))
            searchResults=breweryRepository.findByType(searchText);
        model.addAttribute("searchResults", searchResults);
        return "personal_page";
    }

    @GetMapping("/getname")
    public String getName(@RequestParam(name = "name") String breweryName, Model model) {
        List<Brewery> breweryList=breweryRepository.findByName(breweryName);
        Brewery brewery=breweryList.get(0);
        List<Review> reviewList=reviewRepository.findAllByBreweryId(brewery.getId());
        model.addAttribute("brewery", brewery);
        model.addAttribute("ratings",reviewList);
        return "brewery_page";
    }

    @PostMapping("/addReview/{breweryId}")
    public String addReview(@PathVariable String breweryId,
                            @RequestParam int rating,
                            @RequestParam String description, Model model) {
        Brewery brewery=breweryRepository.findById(breweryId).get();
        Review review=new Review();
        review.setBreweryId(breweryId);
        review.setDescription(description);
        review.setRating(rating);
        reviewRepository.save(review);
        List<Review> reviewList=reviewRepository.findAllByBreweryId(breweryId);
        model.addAttribute("brewery", brewery);
        model.addAttribute("ratings",reviewList);
        return "brewery_page";

    }
}
