package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {
    Button button;
    ImageButton send_button;
    ImageButton run;
    ImageButton add;
    ImageButton meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        run =(ImageButton) findViewById(R.id.imageView4);
        add =(ImageButton) findViewById(R.id.imageView5);
        meals =(ImageButton)findViewById(R.id.imageView7);
        send_button = (ImageButton) findViewById(R.id.imageView3);
        button = (Button) findViewById(R.id.linkshare);


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
    public void onClick2(View v) {
        Intent intent = new Intent(this, Exercise1.class);
        startActivity(intent);

    }
    public void onClick(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/groups/488073742545878");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}