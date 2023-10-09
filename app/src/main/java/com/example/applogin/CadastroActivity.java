package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

        Usuario usuario;
        FirebaseAuth autenticacao;
        EditText campoNome, campoEmail, campoSenha;

        Button botaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializar();
    }

    private void inicializar(){


    campoEmail = findViewById(R.id.editTextEmail);
    campoSenha = findViewById(R.id.editTextSenha);
    campoNome = findViewById(R.id.editTextNome);
    botaoCadastro = findViewById(R.id.buttonCadastrar);

    }
}