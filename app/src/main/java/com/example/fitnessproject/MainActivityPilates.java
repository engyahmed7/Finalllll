package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivityPilates extends AppCompatActivity implements RecycleViewOnItemClick4 {
    String s1[], s2[];
    int images[] = {R.drawable.deadbug2, R.drawable.pelvicpresss2, R.drawable.sideplankk2, R.drawable.swan2};
    String urls []={"https://www.youtube.com/watch?v=8NBNM8haZx0","https://www.youtube.com/watch?v=Ua_slarXMC4","https://www.youtube.com/watch?v=XeN4pEZZJNI","https://www.youtube.com/watch?v=KAotX1bDGps"};
    private RecyclerView mRecycleView;
    private CustomAdapter4 myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pilates);
        s1 = getResources().getStringArray(R.array.Pilates);
        s2 = getResources().getStringArray(R.array.description4);
        myCustomAdapter = new CustomAdapter4(this, s1, s2, images,urls, this);
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