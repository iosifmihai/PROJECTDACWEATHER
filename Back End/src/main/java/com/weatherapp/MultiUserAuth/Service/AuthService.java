package com.weatherapp.MultiUserAuth.Service;

import com.weatherapp.MultiUserAuth.Model.User;
import com.weatherapp.MultiUserAuth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();

    public String register(User user) {

        if(checkUserExist(user) == true)
            return "Error while adding user";

        user.setToken(generateToken());

        userRepository.save(user);

        return "User registration successful";
    }

    private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }

    private boolean checkUserExist(User user) {

        User existingUser = userRepository.findById(user.getUsername()).orElse(null);

        if(existingUser == null)
            return false;
        return true;

    }

    public String login(User user) {
        User existingUser = userRepository.findById(user.getUsername()).orElse(null);

        if(existingUser == null)
            return "";
        return existingUser.getToken();
    }
}
