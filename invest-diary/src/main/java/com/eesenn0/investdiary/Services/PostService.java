package com.eesenn0.investdiary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eesenn0.investdiary.Entities.Post;
import com.eesenn0.investdiary.Entities.User;
import com.eesenn0.investdiary.Repos.PostRepository;
import com.eesenn0.investdiary.Requests.PostCreateRequest;
import com.eesenn0.investdiary.Requests.PostUpdateRequest;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }
    
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }

        return postRepository.findAll();
    }

    public Post createPost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUser(newPostRequest.getUserId());

        if (user == null) {
            return null;
        }

        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);

        return postRepository.save(toSave);
    }

    public Post updatePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            postRepository.save(toUpdate);
            return toUpdate;
        } else
            return null;
    }
    
}
