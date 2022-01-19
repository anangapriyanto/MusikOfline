package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[], s5[];
    int images[] = {
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok,
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.title);
        s2 = getResources().getStringArray(R.array.description);
        s3 = getResources().getStringArray(R.array.adalah);
        s4 = getResources().getStringArray(R.array.terjemahan);
        s5 = getResources().getStringArray(R.array.makna);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, s4, s5,  images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}