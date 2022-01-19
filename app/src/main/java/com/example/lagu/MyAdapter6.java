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

public class MyAdapter6 extends RecyclerView.Adapter<MyAdapter6.MyViewHolder> {

    String data26[], data27[], data28[], data29[], data30[];
    int images6[];
    Context context;

    public MyAdapter6(Context ct,String s26[], String s27[],String s28[], String s29[],String s30[], int img6[]) {
        context = ct;
        data26 = s26;
        data27 = s27;
        data28 = s28;
        data29 = s29;
        data30 = s30;
        images6 = img6;

    }

    @NonNull
    @Override
    public MyAdapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row6, parent,false);
        return new MyAdapter6.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter6.MyViewHolder holder, final int position) {
        holder.myText26.setText(data26[position]);
        holder.mainLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity6.class);
                intent.putExtra("data26",data26[position]);
                intent.putExtra("data27",data27[position]);
                intent.putExtra("data28",data28[position]);
                intent.putExtra("data29",data29[position]);
                intent.putExtra("data30",data30[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images6.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText26;
        ImageView myImage6;
        ConstraintLayout mainLayout6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText26 = itemView.findViewById(R.id.myText26);
            myImage6 = itemView.findViewById(R.id.myImageView6);
            mainLayout6 = itemView.findViewById(R.id.mainLayout6);
        }
    }
}
