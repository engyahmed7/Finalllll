package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;


public class MainActivity6 extends AppCompatActivity implements RecycleViewOnItemClick5{
    String s1[],s2[];
    int images[] = {R.drawable.yoga,R.drawable.pilates,R.drawable.fullbody,R.drawable.stretching3};
    ImageButton home;
    ImageButton add;
    ImageButton meals;
    private RecyclerView mRecycleView;
    private CustomAdapter5 myCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        s1 = getResources().getStringArray(R.array.workouts);
        s2 = getResources().getStringArray(R.array.description5);
        myCustomAdapter = new CustomAdapter5(this,s1,s2,images,this);
        mRecycleView =findViewById(R.id.recycleView);
        home =(ImageButton)findViewById(R.id.imageView2);
        add =(ImageButton) findViewById(R.id.imageView5);
        meals =(ImageButton)findViewById(R.id.imageView7);
        // mCustomAdapter = new CustomAdapter(mWordList);
        mRecycleView.setAdapter(myCustomAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
   public void onItemClick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(this, MainActivityYoga.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(this, MainActivityPilates.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, MainActivityFull.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, MainActivityStretch.class);
                startActivity(intent3);
                break;

            //do the same for every card possible
        }
    }

    public void home(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
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

//      Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//      startActivity(intent);

}