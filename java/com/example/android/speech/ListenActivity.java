package com.example.android.speech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ListenActivity extends AppCompatActivity {
    public static String videoPath;
    public static String infoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar);
        ImageView imgv = findViewById(R.id.info);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListenActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
    }
    public void videoPage(View v) {
    if(v == findViewById(R.id.vb1)) {
        infoId = "s";
        videoPath = "android.resource://com.example.android.speech/" + R.raw.ss;
        Intent i = new Intent(ListenActivity.this,VideoActivity.class);
        startActivity(i);
        }
        if(v == findViewById(R.id.vb2)) {
            infoId = "r";
            videoPath = "android.resource://com.example.android.speech/" + R.raw.rr;
            Intent i = new Intent(ListenActivity.this,VideoActivity.class);
            startActivity(i);
        }
        if(v == findViewById(R.id.vb3)) {
            infoId = "a";
            videoPath = "android.resource://com.example.android.speech/" + R.raw.aa;
            Intent i = new Intent(ListenActivity.this,VideoActivity.class);
            startActivity(i);
        }
        if(v == findViewById(R.id.vb4)) {
            infoId = "k";
            videoPath = "android.resource://com.example.android.speech/" + R.raw.ka;
            Intent i = new Intent(ListenActivity.this,VideoActivity.class);
            startActivity(i);
        }
    }
}