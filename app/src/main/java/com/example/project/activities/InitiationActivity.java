package com.example.project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.model.User;
import com.example.project.sql.InputValidation;

public class InitiationActivity extends AppCompatActivity {

    Button btnEditar, BtnEliminar, BtnMostrar, btnSalir;
    TextView nombre;
    int id = 0;
    User u;
    InputValidation dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiation);

        nombre =(TextView)findViewById(R.id.textViewNombre);


        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        dao = new InputValidation(this);
        u = dao.getUsuarioById(id);

        //Imprimir el nombre del susuario que inicio sesión
        nombre.setText(u.getTx_nombre() + " "+u.getTx_apellido());

    }
}