package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseoffset;
    private boolean running;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        imageView = (ImageView) findViewById(R.id.start);

    }

    public void pause(View view){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            imageView.setImageResource(R.drawable.pause);
            running=true;

        }else {
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime()-chronometer.getBase();
            running=false;
            imageView.setImageResource(R.drawable.start);


        }

    }

//    public void start(View view){
//        if (running){
//            chronometer.stop();
//            running=false;
//            imageView.setImageResource(R.drawable.start);
//
//        }
//    }

    public void reset(View view){

        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset=0;

    }
}