package com.example.appsdevelopers.MobileeAppWeb.shared;

import java.util.UUID;

public class Utils {

    public String generateUserId() {

        return UUID.randomUUID().toString();
    }


}
