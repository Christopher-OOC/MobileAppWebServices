package com.example.appsdevelopers.MobileeAppWeb.userservice.impl;

import com.example.appsdevelopers.MobileeAppWeb.request.UserDetailsRequestModel;
import com.example.appsdevelopers.MobileeAppWeb.response.UserRest;
import com.example.appsdevelopers.MobileeAppWeb.userservice.UserService;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users = new HashMap<>();

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        users.put(userId, returnValue);

        return returnValue;
    }

}
