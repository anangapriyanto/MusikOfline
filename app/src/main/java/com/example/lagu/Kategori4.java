package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori4 extends AppCompatActivity {

    RecyclerView recyclerView4;

    String s16[], s17[], s18[], s19[], s20[];
    int images4[] = {
            R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView4 = findViewById(R.id.recyclerView4);

        s16 = getResources().getStringArray(R.array.title4);
        s17 = getResources().getStringArray(R.array.description4);
        s18 = getResources().getStringArray(R.array.adalah4);
        s19 = getResources().getStringArray(R.array.terjemahan4);
        s20 = getResources().getStringArray(R.array.makna4);

        MyAdapter4 myAdapter4 = new MyAdapter4(this, s16, s17, s18, s19, s20,  images4);
        recyclerView4.setAdapter(myAdapter4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
    }
}