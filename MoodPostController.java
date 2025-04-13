package com.moodboard.controller;

import com.moodboard.model.MoodPost;
import com.moodboard.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class MoodPostController {

    private final MockDataService mockDataService;

    @Autowired
    public MoodPostController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute MoodPost moodPost) {
        // In a real application, you would handle file uploads here
        // For our mock, we'll just use the provided imageUrl or default to a placeholder
        
        if (moodPost.getImageUrl() == null || moodPost.getImageUrl().isEmpty()) {
            moodPost.setImageUrl("/images/" + moodPost.getMood().toLowerCase() + ".jpg");
        }
        
        // Set a default username for now (in a real app, this would come from authentication)
        moodPost.setUsername("user");
        
        // Add the post to our mock database
        mockDataService.addPost(moodPost);
        
        // Redirect to the homepage
        return "redirect:/";
    }
} 