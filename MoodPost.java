package com.moodboard.model;

import java.time.LocalDateTime;

public class MoodPost {
    private Long id;
    private String mood;
    private String caption;
    private String imageUrl;
    private String username;
    private LocalDateTime createdAt;

    // Constructor with all fields
    public MoodPost(Long id, String mood, String caption, String imageUrl, String username, LocalDateTime createdAt) {
        this.id = id;
        this.mood = mood;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.username = username;
        this.createdAt = createdAt;
    }

    // Simplified constructor
    public MoodPost(String mood, String caption, String imageUrl) {
        this.mood = mood;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.username = "user";
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
} 