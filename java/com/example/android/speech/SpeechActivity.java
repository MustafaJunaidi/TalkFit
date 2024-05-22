package com.example.android.speech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpeechActivity extends AppCompatActivity {
    String[] sArr = {"سمين","سامر","سراب","سم","سار","سور"};
    String[] rArr = {"رحمة","رعد","رضيع","رداء","رد","رش","رز","رنا","ربطة","رجعة","رقعة"};
    String[] aArr = {"عيد","عام","عواء","عمل","عمى","عقل","علق"};
    String[] kArr = {"كوب","كوخ","كيس","كافي","كسر","كبير","كار"};
    protected static final int RESAULT_SPEECH = 1;
    Button bt;
    Button btRewatch;
    TextView tx;
    TextView result;
    TextView txSound;
    String letter = "س";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar);
        ImageView imgv = findViewById(R.id.info);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpeechActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });

        bt = findViewById(R.id.sButton);
        tx = findViewById(R.id.sText);
        result = findViewById(R.id.sResult);
        btRewatch = findViewById(R.id.rewatch);
        txSound = findViewById(R.id.sound);
        int number = (int)(Math.random() * 7);
        txSound.setText(txSound.getText() + " " + sArr[number]);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx.setVisibility(View.VISIBLE);
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ar");
                try {
                    startActivityForResult(i,RESAULT_SPEECH);
                    tx.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Your device doesn't support speech to text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESAULT_SPEECH:
                if(resultCode == RESULT_OK && data != null) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String speech = text.get(0) + " ";
                    String word = speech.substring(0,speech.indexOf(' '));
                    tx.setText(word);
                    if((word.charAt(0) + "").equalsIgnoreCase(letter)) {
                        result.setText("صحيح");
                        result.setBackgroundColor(Color.parseColor("#00FF00"));
                        btRewatch.setVisibility(View.INVISIBLE);
                    }
                    else {
                        result.setText("خطأ");
                        result.setBackgroundColor(Color.parseColor("#FF0000"));
                        btRewatch.setVisibility(View.VISIBLE);
                    }
                    result.setVisibility(View.VISIBLE);
                    if(letter == "س")
                        txSound.setText("اقرأ الكلمة التالية:" + " " + sArr[(int)(Math.random() * 6)]);
                    if(letter == "ر")
                        txSound.setText("اقرأ الكلمة التالية:" + " " + rArr[(int)(Math.random() * 11)]);
                    if(letter == "ع")
                        txSound.setText("اقرأ الكلمة التالية:" + " " + aArr[(int)(Math.random() * 7)]);
                    if(letter == "ك")
                        txSound.setText("اقرأ الكلمة التالية:" + " " + kArr[(int)(Math.random() * 7)]);

                }
                break;
        }
    }

    public void rewatch (View v) {
        if(letter == "س") {
            ListenActivity.videoPath = "android.resource://com.example.android.speech/" + R.raw.ss;
            ListenActivity.infoId = "s";
        }
        if(letter == "ر") {
            ListenActivity.videoPath = "android.resource://com.example.android.speech/" + R.raw.rr;
            ListenActivity.infoId = "r";
        }
        if(letter == "ع") {
            ListenActivity.videoPath = "android.resource://com.example.android.speech/" + R.raw.aa;
            ListenActivity.infoId = "a";
        }
        if(letter == "ك") {
            ListenActivity.videoPath = "android.resource://com.example.android.speech/" + R.raw.ka;
            ListenActivity.infoId = "k";
        }

        startActivity(new Intent(this,VideoActivity.class));
    }
    public void pickSound(View v) {
        if(v == findViewById(R.id.s1)) {
            letter = "س";
            txSound.setText("اقرأ الكلمة التالية:" + " " + sArr[(int)(Math.random() * 6)]);
        }
        if(v == findViewById(R.id.s2)) {
            letter = "ر";
            txSound.setText("اقرأ الكلمة التالية:" + " " + rArr[(int)(Math.random() * 11)]);
        }
        if(v == findViewById(R.id.s3)) {
            letter = "ع";
            txSound.setText("اقرأ الكلمة التالية:" + " " + aArr[(int)(Math.random() * 7)]);
        }
        if(v == findViewById(R.id.s4)) {
            letter = "ك";
            txSound.setText("اقرأ الكلمة التالية:" + " " + kArr[(int)(Math.random() * 7)]);
        }
        }
    }
