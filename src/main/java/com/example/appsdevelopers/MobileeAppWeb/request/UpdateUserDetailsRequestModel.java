package com.example.appsdevelopers.MobileeAppWeb.request;

import jakarta.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "First name cannot be null")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    public @NotNull(message = "First name cannot be null") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "First name cannot be null") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "Last name cannot be null") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "Last name cannot be null") String lastName) {
        this.lastName = lastName;
    }
}
