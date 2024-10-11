package com.example.appsdevelopers.MobileeAppWeb.userservice;

import com.example.appsdevelopers.MobileeAppWeb.request.UserDetailsRequestModel;
import com.example.appsdevelopers.MobileeAppWeb.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);
}
