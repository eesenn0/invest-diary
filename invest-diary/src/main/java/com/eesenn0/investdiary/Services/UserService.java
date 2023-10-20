package com.eesenn0.investdiary.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eesenn0.investdiary.Entities.User;
import com.eesenn0.investdiary.Repos.UserRepository;

@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
