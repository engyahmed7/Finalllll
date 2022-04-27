package com.example.fitnessproject;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.LayoutInflater;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter5 extends RecyclerView.Adapter<CustomAdapter5.ViewHolder> {
    String data1[],data2[];
    int images[];
    Context context;
    private  RecycleViewOnItemClick5 recycleViewOnItemClick;

    public CustomAdapter5(Context ct, String []s1,String []s2,int []img,RecycleViewOnItemClick5 recycleViewOnItemClick)
    {

        this.context =ct;
        this.data1 =s1;
        this.data2 =s2;
        this. images =img;
        this.recycleViewOnItemClick =recycleViewOnItemClick;

    }




    @Override
    public CustomAdapter5.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent ,false);

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
                public void onClick(View view) {
                    recycleViewOnItemClick.onItemClick(getAdapterPosition());
                }
            });
        }



    }
    private class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int verticalSpaceHeight;

        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;
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
