package com.example.mylibraryjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.libjava.myClassJava;

public class MainActivityJoke extends AppCompatActivity {

    public static TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        myClassJava joker = new myClassJava();

        textview = (TextView)  findViewById(R.id.tv_joke);
        textview.setText(joker.getJoke());
    }
}
