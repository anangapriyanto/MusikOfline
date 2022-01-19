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

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {

    String data16[], data17[], data18[], data19[], data20[];
    int images4[];
    Context context;

    public MyAdapter4(Context ct,String s16[], String s17[],String s18[], String s19[],String s20[], int img4[]) {
        context = ct;
        data16 = s16;
        data17 = s17;
        data18 = s18;
        data19 = s19;
        data20 = s20;
        images4 = img4;

    }

    @NonNull
    @Override
    public MyAdapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row4, parent,false);
        return new MyAdapter4.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter4.MyViewHolder holder, final int position) {
        holder.myText16.setText(data16[position]);
        holder.mainLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity4.class);
                intent.putExtra("data16",data16[position]);
                intent.putExtra("data17",data17[position]);
                intent.putExtra("data18",data18[position]);
                intent.putExtra("data19",data19[position]);
                intent.putExtra("data20",data20[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images4.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText16;
        ImageView myImage4;
        ConstraintLayout mainLayout4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText16 = itemView.findViewById(R.id.myText16);
            myImage4 = itemView.findViewById(R.id.myImageView4);
            mainLayout4 = itemView.findViewById(R.id.mainLayout4);
        }
    }
}

