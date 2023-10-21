package com.eesenn0.investdiary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eesenn0.investdiary.Entities.Post;
import com.eesenn0.investdiary.Repos.PostRepository;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }

        return postRepository.findAll();
    }
    
}
