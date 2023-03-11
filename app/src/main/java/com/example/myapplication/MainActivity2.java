package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textview1 = findViewById(R.id.textView);
        String str = getIntent().getStringExtra("massage");
        textview1.setText(str);
    }
}
/*
    def core_version = "1.6.0"
    dependencies {
        implementation "androidx.core:core:$core_version"
    }

 */