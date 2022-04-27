package com.example.fitnessproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitnessproject.R;

public class MainActivity extends AppCompatActivity {
    private EditText name,age,pass,weight;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.username) ;
        age=findViewById(R.id.Age);
        pass=findViewById(R.id.password);
        weight=findViewById(R.id.weight);
        home=findViewById(R.id.login);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp =getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit =sp.edit();
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age" , Integer.parseInt(age.getText().toString()));
        myEdit.putString("pass", pass.getText().toString());
        myEdit.putInt("weight" , Integer.parseInt(weight.getText().toString()));
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh =getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sh.getString("name" , "");
        int a=sh.getInt("age" , 0);
        String s2 = sh.getString("pass" , "");
        int a2=sh.getInt("weight" , 0);
        name.setText(s1);
        age.setText(String.valueOf(a));
        pass.setText(s2);
        weight.setText(String.valueOf(a2));
    }
    public void Facebook(View view){
        Uri uri = Uri.parse("http://www.facebook.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void Instagram(View view){
        Uri uri = Uri.parse("http://www.instagram.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void Whatsapp(View view){
        Uri uri = Uri.parse("http://www.whatsapp.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void Twitter(View view){
        Uri uri = Uri.parse("http://www.twitter.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void onClick5(View v) {
        Intent intent1 = new Intent(this, MainActivity1.class);
        startActivity(intent1);
    }
}