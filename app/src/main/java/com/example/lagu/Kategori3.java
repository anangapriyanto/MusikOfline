package com.example.lagu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Kategori3 extends AppCompatActivity {

    RecyclerView recyclerView3;

    String s11[], s12[], s13[], s14[], s15[];
    int images3[] = {
            R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok, R.drawable.ctok
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView3 = findViewById(R.id.recyclerView3);

        s11 = getResources().getStringArray(R.array.title3);
        s12 = getResources().getStringArray(R.array.description3);
        s13 = getResources().getStringArray(R.array.adalah3);
        s14 = getResources().getStringArray(R.array.terjemahan3);
        s15 = getResources().getStringArray(R.array.makna3);

        MyAdapter3 myAdapter3 = new MyAdapter3(this, s11, s12, s13, s14, s15,  images3);
        recyclerView3.setAdapter(myAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
    }
}