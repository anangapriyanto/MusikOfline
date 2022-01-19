package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori6 extends AppCompatActivity {

    RecyclerView recyclerView6;

    String s26[], s27[], s28[], s29[], s30[];
    int images6[] = {
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        recyclerView6 = findViewById(R.id.recyclerView6);

        s26 = getResources().getStringArray(R.array.title6);
        s27 = getResources().getStringArray(R.array.description6);
        s28 = getResources().getStringArray(R.array.adalah6);
        s29 = getResources().getStringArray(R.array.terjemahan6);
        s30 = getResources().getStringArray(R.array.makna6);

        MyAdapter6 myAdapter6 = new MyAdapter6(this, s26, s27, s28, s29, s30,  images6);
        recyclerView6.setAdapter(myAdapter6);
        recyclerView6.setLayoutManager(new LinearLayoutManager(this));
    }
}