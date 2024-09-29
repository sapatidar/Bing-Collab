package com.bing.collab.services;

import com.bing.collab.models.User;
import com.bing.collab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    public User register(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserDetails(String email){
        return userRepository.findById(email);
    }

    public List<Optional<User>> getConnections(String userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Optional<User>> connections = new ArrayList<>();
        for(String connectionUserId: user.get().getConnections()){
            connections.add(userRepository.findById(connectionUserId));
        }
        return connections;
    }
}
