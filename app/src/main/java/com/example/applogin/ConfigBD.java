package com.example.applogin;

import com.google.firebase.auth.FirebaseAuth;

public class ConfigBD {

    private static FirebaseAuth auth;

    public static FirebaseAuth Firebaseverif(){
        if (auth == null){
            auth =FirebaseAuth.getInstance();
        }
        return auth;
    }
}
