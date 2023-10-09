package com.example.applogin;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioAut {

    public static FirebaseUser usariologado(){
        FirebaseAuth usuario = ConfigBD.Firebaseverif();
        return usuario.getCurrentUser();

    }
}
