package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori2 extends AppCompatActivity {

    RecyclerView recyclerView2;

    String s6[], s7[], s8[], s9[], s10[];
    int images2[] = {
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView2 = findViewById(R.id.recyclerView2);

        s6 = getResources().getStringArray(R.array.title2);
        s7 = getResources().getStringArray(R.array.description2);
        s8 = getResources().getStringArray(R.array.adalah2);
        s9 = getResources().getStringArray(R.array.terjemahan2);
        s10 = getResources().getStringArray(R.array.makna2);

        MyAdapter2 myAdapter2 = new MyAdapter2(this, s6, s7, s8, s9, s10,  images2);
        recyclerView2.setAdapter(myAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }
}