package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity1 extends AppCompatActivity {


    PieChart piechart;
    TextView caloriesNum;
    EditText AddCalories;
    TextView Date;


    private Button button_notify;
    //unique id
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    ImageButton home;
    ImageButton run;
    ImageButton add;
    ImageButton meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        piechart = findViewById(R.id.pie_chart);
        //make pie chart
        setupPieChart();

        //display pie chart
        loadPieChartData();

        caloriesNum = findViewById(R.id.textView3);
        AddCalories = findViewById(R.id.editTextNumber);
        Date = findViewById(R.id.button);
        home =(ImageButton)findViewById(R.id.imageView2);
        run =(ImageButton) findViewById(R.id.imageView4);
        add =(ImageButton) findViewById(R.id.imageView5);
        meals =(ImageButton)findViewById(R.id.imageView7);
        // to make date (current date)
        Calendar calender = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance().format(calender.getTime());
        Date.setText(CurrentDate);

        button_notify = findViewById(R.id.saveButton);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();

            }
        });
        createNotificationChannel();

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

    //Notification
    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    public void createNotificationChannel(){
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Calories Notification", NotificationManager
                    .IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(){
        Intent notificationIntent = new Intent(this, MainActivity1.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("Calories Saved Successfully")
                .setSmallIcon(R.drawable.ic_android9)
                .setColor(Color.rgb(135,103,191))
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true);
        return notifyBuilder;
    }


    //Pie Chart

    protected void setupPieChart()
    {
        piechart.setDrawHoleEnabled(true);
        piechart.setUsePercentValues(true);
        piechart.setEntryLabelTextSize(12);
        piechart.setEntryLabelColor(Color.BLACK);
        piechart.setCenterText("Your Standard");
        piechart.setCenterTextSize(19);
        piechart.getDescription().setEnabled(false);

//      data of pie chart
        Legend l = piechart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setEnabled(true);
    }

    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(0.2f, "Suger"));
        entries.add(new PieEntry(0.15f, "Carb"));
        entries.add(new PieEntry(0.10f, "Fats"));
        entries.add(new PieEntry(0.25f, "Protein"));
        entries.add(new PieEntry(0.10f, "Sodium"));


        ArrayList<Integer> colors = new ArrayList<>();
        for (int color : ColorTemplate.JOYFUL_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Categories");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        //put values and % of pie chart (no only not titles)
        data.setDrawValues(true);

        //put data in percentage format
        data.setValueFormatter(new PercentFormatter(piechart));

        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        //display chart
        piechart.setData(data);

        // Easing.EaseInOutQuad -> how to rotate (animation)
        piechart.animateY(1400, Easing.EaseInOutQuad);
    }

    // Add Function
    public void AddFun(View view) {
        int res, n1, n2;

        if (AddCalories.getText().toString().isEmpty())
        {
            res = (int) Double.parseDouble(caloriesNum.getText().toString());
        }
        else
        {
            n1 = (int) Double.parseDouble(caloriesNum.getText().toString());
            n2 = (int) Double.parseDouble(AddCalories.getText().toString());
            res = n1 + n2;
        }
        caloriesNum.setText(String.valueOf(res));
    }

    //Remove Function
    public void Remove(View view) {
        int res, n1, n2;

        if (AddCalories.getText().toString().isEmpty())
        {
            res = (int) Double.parseDouble(caloriesNum.getText().toString());
        }
        else
        {
            n1 = (int) Double.parseDouble(caloriesNum.getText().toString());
            n2 = (int) Double.parseDouble(AddCalories.getText().toString());
            res = n1 - n2;
        }
        caloriesNum.setText(String.valueOf(res));
    }

    //Shared Preference
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences =getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit =sharedPreferences.edit();
        myEdit.putString("Calories", caloriesNum.getText().toString());
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences =getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1 = sharedPreferences.getString("Calories" , "0");
        caloriesNum.setText(s1);
    }

    public void onClick3(View v) {
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
    }

}



