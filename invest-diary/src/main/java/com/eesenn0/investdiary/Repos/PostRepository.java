package com.eesenn0.investdiary.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eesenn0.investdiary.Entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findByUserId(Long long1);
    
}
