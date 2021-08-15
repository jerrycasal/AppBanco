package com.example.project.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.model.User;
import com.example.project.sql.InputValidation;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username, pass;
    private Button btn_iniciaSesion, btn_registrar;
     InputValidation dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.tx_nombre);
        pass = (EditText) findViewById(R.id.tx_pass);
        btn_iniciaSesion = (Button) findViewById(R.id.btn_iniciaSesion);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);


        btn_iniciaSesion.setOnClickListener(this);
        btn_registrar.setOnClickListener(this);

        dao = new InputValidation(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_iniciaSesion:
                String u = username.getText().toString();
                String p = pass.getText().toString();
                if(u.equals("")){
                    username.setError("Este Campo no puede estar vacio");
                }else if(p.equals("")){
                    pass.setError("Este Campo no puede estar vacio");
                }else if(dao.login(u,p)==1){
                    User ux = dao.getUsuario(u,p);
                    Toast.makeText(this,"Welcome to App Bank Sanz", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this, InitiationActivity.class);
                    i2.putExtra("Id", ux.getId());
                    startActivity(i2);
                }else{
                    Toast.makeText(this,"Usuario y/o clave incorrectos", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.btn_registrar:
                Intent i = new Intent(this, RegisterActivity.class);
                startActivity(i);
                break;

        }

    }


}

//https://www.youtube.com/watch?v=r2hs9OuWZOs primer video
// https://www.youtube.com/watch?v=n10SRistBVg  segundo video para ya hacer CRUD