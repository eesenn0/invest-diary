package com.eesenn0.investdiary.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eesenn0.investdiary.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
