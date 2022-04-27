package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityStretch extends AppCompatActivity implements RecycleViewOnItemClick3 {
    String s1[], s2[];
    int images[] = {R.drawable.forward_bend2, R.drawable.hip_flexor2, R.drawable.shoulder_stretch3, R.drawable.toe_touch2, R.drawable.tricep_stretch2};
    String urls []={"https://www.youtube.com/watch?v=g7Uhp5tphAs&t=24s","https://www.youtube.com/watch?v=7bRaX6M2nr8","https://www.youtube.com/watch?v=6jHsraw2NIk","https://www.youtube.com/watch?v=tNVNSpA_Xkg","https://www.youtube.com/watch?v=BglqDh5Xozc"};
    private RecyclerView mRecycleView;
    private CustomAdapter3 myCustomAdapter;
    ImageButton home;
    ImageButton run;
    ImageButton add;
    ImageButton meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stretch);
        s1 = getResources().getStringArray(R.array.Stretch);
        s2 = getResources().getStringArray(R.array.description3);
        myCustomAdapter = new CustomAdapter3(this, s1, s2, images,urls, this);
        mRecycleView = findViewById(R.id.recycleView);
        home =(ImageButton)findViewById(R.id.imageView2);
        run =(ImageButton) findViewById(R.id.imageView4);
        add =(ImageButton) findViewById(R.id.imageView5);
        meals =(ImageButton)findViewById(R.id.imageView7);
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
    public void home(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    public void run(View view) {
        Intent intent = new Intent(this,MainActivity6.class);
        startActivity(intent);
    }

    public void add(View view) {
        Intent intent = new Intent(this,MainActivity1.class);
        startActivity(intent);
    }

    public void meals(View view) {
        Intent intent = new Intent(this,Exercise1.class);
        startActivity(intent);
    }
}