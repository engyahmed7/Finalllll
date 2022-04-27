package com.example.fitnessproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivityFull extends AppCompatActivity implements RecycleViewOnItemClick2 {
    String s1[], s2[];
    int images[] = {R.drawable.lunges2, R.drawable.pelviclifttt2, R.drawable.pushup4, R.drawable.squats2};
    String urls []={"https://www.youtube.com/watch?v=3XDriUn0udo","https://www.youtube.com/watch?v=yrts5Q29HeY","https://www.youtube.com/watch?v=FaIpD_zfrJI","https://www.youtube.com/watch?v=aclHkVaku9U"};
    private RecyclerView mRecycleView;
    private CustomAdapter2 myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_full);
        s1 = getResources().getStringArray(R.array.Full);
        s2 = getResources().getStringArray(R.array.description2);
        myCustomAdapter = new CustomAdapter2(this, s1, s2, images,urls, this);
        mRecycleView = findViewById(R.id.recycleView);
        // mCustomAdapter = new CustomAdapter(mWordList);
        mRecycleView.setAdapter(myCustomAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        Uri url = Uri.parse(urls[position]);
        Intent intent = new Intent(Intent.ACTION_VIEW,url);
        startActivity(intent);
    }
}
