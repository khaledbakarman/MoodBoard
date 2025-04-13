package com.moodboard.service;

import com.moodboard.model.MoodPost;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MockDataService {
    private final List<MoodPost> posts = new ArrayList<>();
    private Long nextId = 1L;

    // Initialize with some mock data
    public MockDataService() {
        addMockPost("Happy", "Having a great day at the beach!", "/images/happy.jpg", "alex123");
        addMockPost("Excited", "First day at my new job!", "/images/excited.jpg", "taylor22");
        addMockPost("Relaxed", "Reading a book in the park.", "/images/relaxed.jpg", "jordan99");
        addMockPost("Sad", "Missing my friends today...", "/images/sad.jpg", "sam456");
        addMockPost("Energetic", "Just finished a great workout!", "/images/energetic.jpg", "chris789");
        addMockPost("Tired", "Long day at work...", "/images/tired.jpg", "pat333");
        addMockPost("Inspired", "Just visited an amazing art exhibition!", "/images/inspired.jpg", "alex123");
        addMockPost("Grateful", "Thankful for my supportive family.", "/images/grateful.jpg", "jordan99");
    }

    private void addMockPost(String mood, String caption, String imageUrl, String username) {
        posts.add(new MoodPost(nextId++, mood, caption, imageUrl, username, LocalDateTime.now().minusDays(posts.size())));
    }

    // Get all posts
    public List<MoodPost> getAllPosts() {
        return new ArrayList<>(posts);
    }

    // Get posts by mood
    public List<MoodPost> getPostsByMood(String mood) {
        return posts.stream()
                .filter(post -> post.getMood().equalsIgnoreCase(mood))
                .collect(Collectors.toList());
    }

    // Get posts by username
    public List<MoodPost> getPostsByUsername(String username) {
        return posts.stream()
                .filter(post -> post.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    // Add a new post
    public MoodPost addPost(MoodPost post) {
        post.setId(nextId++);
        post.setCreatedAt(LocalDateTime.now());
        posts.add(post);
        return post;
    }
} 