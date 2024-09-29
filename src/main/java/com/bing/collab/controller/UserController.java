package com.bing.collab.controller;

import com.bing.collab.models.User;
import com.bing.collab.repository.UserRepository;
import com.bing.collab.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/collab")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @PostMapping("/saveUserDetails")
    public User saveUserDetails(@RequestBody User user) {
        return userServices.register(user);
    }

    @PostMapping("/getUserDetails")
    public Optional<User> getUserDetails(@RequestBody String userId) {
        return userServices.findUserDetails(userId);
    }

    @PostMapping("/validateUser")
    public boolean validateUser(@RequestBody String userId) {
        if(userServices.findUserDetails(userId)!= null) return true;
        else return false;
    }

    @PostMapping("/getConnections")
    public List<Optional<User>> getConnections(@RequestBody String userId) {
        return userServices.getConnections(userId);
    }
}
