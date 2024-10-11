package com.example.appsdevelopers.MobileeAppWeb.controller;

import com.example.appsdevelopers.MobileeAppWeb.request.UpdateUserDetailsRequestModel;
import com.example.appsdevelopers.MobileeAppWeb.request.UserDetailsRequestModel;
import com.example.appsdevelopers.MobileeAppWeb.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<String, UserRest> users = new HashMap<>();

    @GetMapping
    public String getUsers(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "1", required = false) int limit
    ) {
        
        return "get users was called page = " + page + ", limit = " + limit;
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {

        if (users.containsKey(userId)) {
            return ResponseEntity.ok(users.get(userId));
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        users.put(userId, returnValue);

        return ResponseEntity.ok(returnValue);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<?> updateUser(
        @PathVariable("userId") String userId,
        @Valid @RequestBody UpdateUserDetailsRequestModel userDetails
    ) {

        UserRest storedUserDetails = users.get(userId);

        if (storedUserDetails == null) {
            return ResponseEntity.noContent().build();
        }

        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return ResponseEntity.ok(storedUserDetails);
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
