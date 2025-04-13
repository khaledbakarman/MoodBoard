package com.moodboard.controller;

import com.moodboard.model.MoodPost;
import com.moodboard.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfileController {

    private final MockDataService mockDataService;

    @Autowired
    public ProfileController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/profile/{username}")
    public String userProfile(@PathVariable String username, Model model) {
        List<MoodPost> userPosts = mockDataService.getPostsByUsername(username);
        model.addAttribute("posts", userPosts);
        model.addAttribute("username", username);
        return "profile";
    }
} 