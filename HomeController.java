package com.moodboard.controller;

import com.moodboard.model.MoodPost;
import com.moodboard.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final MockDataService mockDataService;

    @Autowired
    public HomeController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String mood) {
        List<MoodPost> posts;
        
        if (mood != null && !mood.isEmpty()) {
            posts = mockDataService.getPostsByMood(mood);
            model.addAttribute("filterActive", true);
            model.addAttribute("currentMood", mood);
        } else {
            posts = mockDataService.getAllPosts();
            model.addAttribute("filterActive", false);
        }
        
        model.addAttribute("posts", posts);
        return "index";
    }
    
    @GetMapping("/create")
    public String createMoodForm(Model model) {
        model.addAttribute("moodPost", new MoodPost(null, "", "", "/images/placeholder.jpg", "", null));
        
        // List of available moods for the dropdown
        String[] moods = {"Happy", "Sad", "Excited", "Relaxed", "Energetic", "Tired", "Inspired", "Grateful"};
        model.addAttribute("moods", moods);
        
        return "create";
    }
} 