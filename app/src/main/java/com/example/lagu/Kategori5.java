package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori5 extends AppCompatActivity {

    RecyclerView recyclerView5;

    String s21[], s22[], s23[], s24[], s25[];
    int images5[] = {
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        recyclerView5 = findViewById(R.id.recyclerView5);

        s21 = getResources().getStringArray(R.array.title5);
        s22 = getResources().getStringArray(R.array.description5);
        s23 = getResources().getStringArray(R.array.adalah5);
        s24 = getResources().getStringArray(R.array.terjemahan5);
        s25 = getResources().getStringArray(R.array.makna5);

        MyAdapter5 myAdapter5 = new MyAdapter5(this, s21, s22, s23, s24, s25,  images5);
        recyclerView5.setAdapter(myAdapter5);
        recyclerView5.setLayoutManager(new LinearLayoutManager(this));
    }
}