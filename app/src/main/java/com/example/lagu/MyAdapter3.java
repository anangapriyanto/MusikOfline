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

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {

    String data11[], data12[], data13[], data14[], data15[];
    int images3[];
    Context context;

    public MyAdapter3(Context ct,String s11[], String s12[],String s13[], String s14[],String s15[], int img3[]) {
        context = ct;
        data11 = s11;
        data12 = s12;
        data13 = s13;
        data14 = s14;
        data15 = s15;
        images3 = img3;

    }

    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row3, parent,false);
        return new MyAdapter3.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter3.MyViewHolder holder, final int position) {
        holder.myText11.setText(data11[position]);
        holder.mainLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity3.class);
                intent.putExtra("data11",data11[position]);
                intent.putExtra("data12",data12[position]);
                intent.putExtra("data13",data13[position]);
                intent.putExtra("data14",data14[position]);
                intent.putExtra("data15",data15[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images3.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText11;
        ImageView myImage3;
        ConstraintLayout mainLayout3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText11 = itemView.findViewById(R.id.myText11);
            myImage3 = itemView.findViewById(R.id.myImageView3);
            mainLayout3 = itemView.findViewById(R.id.mainLayout3);
        }
    }
}

