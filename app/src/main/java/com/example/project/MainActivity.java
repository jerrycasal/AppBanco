package com.example.project;



import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.project.activities.LoginActivity;
import com.example.project.activities.RegisterActivity;

import java.util.TimerTask;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        }, 3000);

    }
}

//TimerTask tarea = new TimerTask(){
//            @Override
//            public void run() {
//                Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(i);
//                finish();
//
//            }
//        };
//
//        Timer tiempo = new Timer();
//        tiempo.schedule(tarea,  3000);
