package com.example.lagu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    String data6[], data7[], data8[], data9[], data10[];
    int images2[];
    Context context;

    public MyAdapter2(Context ct,String s6[], String s7[],String s8[], String s9[],String s10[], int img2[]) {
        context = ct;
        data6 = s6;
        data7 = s7;
        data8 = s8;
        data9 = s9;
        data10 = s10;
        images2 = img2;

    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row2, parent,false);
        return new MyAdapter2.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, final int position) {
        holder.myText6.setText(data6[position]);
        holder.mainLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity2.class);
                intent.putExtra("data6",data6[position]);
                intent.putExtra("data7",data7[position]);
                intent.putExtra("data8",data8[position]);
                intent.putExtra("data9",data9[position]);
                intent.putExtra("data10",data10[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images2.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText6;
        ImageView myImage2;
        ConstraintLayout mainLayout2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText6 = itemView.findViewById(R.id.myText6);
            myImage2 = itemView.findViewById(R.id.myImageView2);
            mainLayout2 = itemView.findViewById(R.id.mainLayout2);
        }
    }
}

