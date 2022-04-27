package com.example.fitnessproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.LayoutInflater;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.ViewHolder> {
    String data1[],data2[];
    int images[];
    Context context;
    String [] url;
    private  RecycleViewOnItemClick1 recycleViewOnItemClick;

    public CustomAdapter1(Context ct, String []s1,String []s2,int []img,String [] url,RecycleViewOnItemClick1 recycleViewOnItemClick)
    {
        this.context =ct;
        this.data1 =s1;
        this.data2 =s2;
        this. images =img;
        this.url=url;
        this.recycleViewOnItemClick =recycleViewOnItemClick;
    }

    @Override
    public CustomAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item1, parent ,false);
        return new ViewHolder(view);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;
        ImageView myImage;

        public ViewHolder(View view) {
            super(view);
            myText1 = view.findViewById(R.id.myText1);
            myText2 =view.findViewById(R.id.myText2);
            myImage =view.findViewById(R.id.myImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder,final int position) {
        viewHolder.myText1.setText(data1[position]);
        viewHolder.myText2.setText(data2[position]);
        viewHolder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

}