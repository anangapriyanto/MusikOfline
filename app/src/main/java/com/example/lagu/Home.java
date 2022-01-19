package com.example.lagu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
    private Button db1, db2, db3, db4, db5, db6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        db1 = findViewById(R.id.db1);
        db2 = findViewById(R.id.db2);
        db3 = findViewById(R.id.db3);
        db4 = findViewById(R.id.db4);
        db5 = findViewById(R.id.db5);
        db6 = findViewById(R.id.db6);

        //menuju ke kalkulator
        db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori.class);
                startActivity(B);
            }

        });
        //menuju ke daftar bilangan
        db2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori2.class);
                startActivity(B);
            }

        });
        db3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori3.class);
                startActivity(B);
            }

        });
        db4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori4.class);
                startActivity(B);
            }

        });
        db5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori5.class);
                startActivity(B);
            }

        });
        db6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent B = new Intent(Home.this, Kategori6.class);
                startActivity(B);
            }

        });
    }
}


