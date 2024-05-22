package com.example.android.speech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar);
        ImageView imgv = findViewById(R.id.info);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
    }
    public void trainer(View view){
        Intent i = new Intent(this,ListenActivity.class);
        startActivity(i);
    }
    public void corrector(View view){
        Intent i = new Intent(this,SpeechActivity.class);
        startActivity(i);
    }
}