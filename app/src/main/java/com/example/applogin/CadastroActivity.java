package com.example.applogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

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

    public void validarCampos(View v){
        String nome =campoNome.getText().toString();
        String email =campoEmail.getText().toString();
        String senha =campoSenha.getText().toString();

        if (!nome.isEmpty()){
            if(!email.isEmpty()){
                if (!senha.isEmpty()){

                    usuario = new Usuario();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);

                    cadastrarUsuario(usuario);

                }else {
                    Toast.makeText(this, "Preencha a senha", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(this, "Preencha o email", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show();
        }
    }
    private void cadastrarUsuario(Usuario usuario){

        autenticacao = ConfigBD.Firebaseverif();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar Usuário", Toast.LENGTH_SHORT).show();
                }else {
                    String excecao = "";

                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        excecao="Digite uma senha mais forte";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao="Digite um email valido";
                    }catch (FirebaseAuthUserCollisionException e){
                        excecao="Este email ja foi utilizado";
                    }catch (Exception e){
                        excecao="Erro ao cadastrar usario "+ e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, excecao, Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}