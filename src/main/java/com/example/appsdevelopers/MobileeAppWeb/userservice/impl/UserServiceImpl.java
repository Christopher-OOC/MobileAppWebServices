package com.example.appsdevelopers.MobileeAppWeb.userservice.impl;

import com.example.appsdevelopers.MobileeAppWeb.request.UserDetailsRequestModel;
import com.example.appsdevelopers.MobileeAppWeb.response.UserRest;
import com.example.appsdevelopers.MobileeAppWeb.shared.Utils;
import com.example.appsdevelopers.MobileeAppWeb.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users = new HashMap<>();
    Utils utils;

    public UserServiceImpl() {

    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        users.put(userId, returnValue);

        return returnValue;
    }

}
