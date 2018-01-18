package com.example.mylibraryjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        //Get put extra
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String resultMensage = bundle.getString("PUT_EXTRA_RESULT");

        ((TextView)findViewById(R.id.tvMessage)).setText(resultMensage);

        Toast toast = Toast.makeText(this, resultMensage, Toast.LENGTH_LONG);
        toast.show();

    }
}
