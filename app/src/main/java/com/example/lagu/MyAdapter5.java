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

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    String data21[], data22[], data23[], data24[], data25[];
    int images5[];
    Context context;

    public MyAdapter5(Context ct,String s21[], String s22[],String s23[], String s24[],String s25[], int img5[]) {
        context = ct;
        data21 = s21;
        data22 = s22;
        data23 = s23;
        data24 = s24;
        data25 = s25;
        images5 = img5;

    }

    @NonNull
    @Override
    public MyAdapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row5, parent,false);
        return new MyAdapter5.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter5.MyViewHolder holder, final int position) {
        holder.myText21.setText(data21[position]);
        holder.mainLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity5.class);
                intent.putExtra("data21",data21[position]);
                intent.putExtra("data22",data22[position]);
                intent.putExtra("data23",data23[position]);
                intent.putExtra("data24",data24[position]);
                intent.putExtra("data25",data25[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images5.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText21;
        ImageView myImage5;
        ConstraintLayout mainLayout5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText21 = itemView.findViewById(R.id.myText21);
            myImage5 = itemView.findViewById(R.id.myImageView5);
            mainLayout5 = itemView.findViewById(R.id.mainLayout5);
        }
    }
}
