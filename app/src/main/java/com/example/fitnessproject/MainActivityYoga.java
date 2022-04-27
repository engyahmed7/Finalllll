package com.example.fitnessproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivityYoga extends AppCompatActivity implements RecycleViewOnItemClick1 {
    String s1[], s2[];
    int images[] = {R.drawable.flying_pigeon_pose2, R.drawable.full_boat2, R.drawable.pigeon_pose_kapotasana2, R.drawable.sphinx2};
    String urls []={"https://www.youtube.com/watch?v=2mUqSPdYeuA","https://www.youtube.com/watch?v=8KsyQvwi85Q","https://www.youtube.com/watch?v=0_zPqA65Nok","https://www.youtube.com/watch?v=-J9zcJYACrk"};
    private RecyclerView mRecycleView;
    private CustomAdapter1 myCustomAdapter;
    ImageButton home;
    ImageButton run;
    ImageButton add;
    ImageButton meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_yoga);
        s1 = getResources().getStringArray(R.array.Yoga);
        s2 = getResources().getStringArray(R.array.description1);
        myCustomAdapter = new CustomAdapter1(this, s1, s2, images,urls, this);
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