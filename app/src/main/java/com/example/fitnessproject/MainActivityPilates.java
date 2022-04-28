package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityPilates extends AppCompatActivity implements RecycleViewOnItemClick4 {
    String s1[], s2[];
    int images[] = {R.drawable.deadbug2, R.drawable.pelvicpresss2, R.drawable.sideplankk2, R.drawable.swan2};
    String urls []={"https://www.youtube.com/watch?v=8NBNM8haZx0","https://www.youtube.com/watch?v=Ua_slarXMC4","https://www.youtube.com/watch?v=XeN4pEZZJNI","https://www.youtube.com/watch?v=KAotX1bDGps"};
    private RecyclerView mRecycleView;
    private CustomAdapter4 myCustomAdapter;
    ImageButton home;
    ImageButton run;
    ImageButton add;
    ImageButton meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pilates);
        s1 = getResources().getStringArray(R.array.Pilates);
        s2 = getResources().getStringArray(R.array.description4);
        myCustomAdapter = new CustomAdapter4(this, s1, s2, images,urls, this);
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
        Intent intent = new Intent(this,MainActivity8.class);
        startActivity(intent);
    }
}