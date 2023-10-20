package com.eesenn0.investdiary.Services;

import java.util.List;
import java.util.Optional;

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

    public User saveOneUser(User newUser) {
        return userRepo.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepo.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    
}
