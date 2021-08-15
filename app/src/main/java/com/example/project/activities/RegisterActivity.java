package com.example.project.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.model.User;
import com.example.project.sql.InputValidation;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText us, pass, nom, ap, passConfir;
    Button register, cancel;
    InputValidation dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        us = (EditText) findViewById(R.id.tx_username);
        pass = (EditText) findViewById(R.id.tx_pass);
        passConfir = (EditText) findViewById(R.id.tx_passConfirm);
        nom = (EditText) findViewById(R.id.tx_nombre);
        ap = (EditText) findViewById(R.id.tx_apellido);


        register = findViewById(R.id.btnRegistrarse);
        cancel = findViewById(R.id.btnCancelar);

        register.setOnClickListener(this);
        cancel.setOnClickListener(this);
        dao = new InputValidation(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrarse:
                User u = new User();
                u.setTx_nombre(nom.getText().toString());
                u.setTx_apellido(ap.getText().toString());
                u.setTx_usuario(us.getText().toString());
                u.setTx_password(pass.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "Verifique los campos vacios",Toast.LENGTH_LONG).show();
                }else if(pass.getText().toString().equals(passConfir.getText().toString())){
                        if(pass.getText().toString().length() >= 8)
                        {
                            if(dao.insertUser(u))
                            {
                                Toast.makeText(this, "Registro exitoso",Toast.LENGTH_LONG).show();
                                Intent i2 = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(i2);
                                finish();
                            }else{
                                Toast.makeText(this, "Este usuario ya existe",Toast.LENGTH_LONG).show();
                            }

                        }else{
                            Toast.makeText(this, "La contraseña debe ser mayor o igual a 8 caracteres", Toast.LENGTH_SHORT).show();
                        }

                }else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();

                }


                break;

            case R.id.btnCancelar:
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                break;

        }



    }
}