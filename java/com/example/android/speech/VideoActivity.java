package com.example.android.speech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    //new instructions
    public static SpannableString s = new SpannableString("تعليمات إنتاج صوت س /s/:\n" +
            "\n" +
            "١- ابتسم مع إظهار أسنانك. \n" +
            "\n" +
            "٢- أغلق أسنانك مع المحافظة على الابتسام (ليس بالضرورة أن تضغط على أسنانك بقوة). \n" +
            "\n" +
            "٣- ضع طرف لسانك على أسنانك السفلية، ليس بالضرورة أن يكون شد اللسان على الأسنان قويًا.\n" +
            "\n" +
            "٤- ادفع الهواء.\n" +
            "\n" +
            "٥- تأكد من أن اللسان لا يخرج من بين الأسنان أثناء دفع الهواء، وفي حال خروج اللسان قم بسحبه إلى الوراء وأعد إطباق الأسنان.");
    public static SpannableString r = new SpannableString("تعليمات إنتاج صوت ر /r/:\n" +
            "\n" +
            "١- ضع طرف لسانك على الثنايا العليا (فوق الأسنان العلوية مباشرة).\n" +
            "\n" +
            "٢- ادفع هواءً قوياً بين لسانك وسقف حلقك لتقوم بإنتاج حركة مترددة. \n" +
            "\n" +
            "ملحوظة: قد تتمكن من إنتاج حركة واحدة/ تردد واحد ومع الاستمرار ستتمكن من إنتاج الراء المترددة.");
    public static SpannableString a = new SpannableString("تعليمات إنتاج صوت ع /ʕ/:\n" +
            "\n" +
            "١- اخفض ذقنك حتى يلامس الصدر. \n" +
            "\n" +
            "٢- افتح فمك. \n" +
            "\n" +
            "٣- أنتج الصوت ح /ħ/. ");
    public static SpannableString k = new SpannableString("تعليمات إنتاج صوت ك /k/:\n" +
            "\n" +
            "١- افتح شفتيك.\n" +
            "\n" +
            "٢- أغلق مجرى الهواء من الجزء الخلفي من فمك.\n" +
            "\n" +
            "٣- أطلق الهواء بقوة مباعدًا بين نهاية اللسان وسقف الحلق.");

    VideoView videoView;
    int videoState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar);
        ImageView imgv = findViewById(R.id.info);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });


        videoView = findViewById(R.id.video);
        Uri uri = Uri.parse(ListenActivity.videoPath);
        videoView.setVideoURI(uri);
        videoView.seekTo(1);
        //MediaController mc = new MediaController(this);
        //videoView.setMediaController(mc);
        TextView tx = findViewById(R.id.cons);
        StyleSpan span = new StyleSpan(Typeface.BOLD);
        if(ListenActivity.infoId.equalsIgnoreCase("s")) {
            s.setSpan(span,0,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tx.setText(s);
        }
        if(ListenActivity.infoId.equalsIgnoreCase("r")) {
            tx.setText(r);
            r.setSpan(span,0,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
        if(ListenActivity.infoId.equalsIgnoreCase("a")) {
            tx.setText(a);
            a.setSpan(span,0,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if(ListenActivity.infoId.equalsIgnoreCase("k")) {
            k.setSpan(span,0,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tx.setText(k);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoView.seekTo(1);
    }

    public void videoPlay(View v) {
        Button bt = (Button)findViewById(R.id.play);
        videoState++;
        if(videoState%2 == 1) {
            videoView.start();
            bt.setText("توقّف");
        }
        else {
            videoView.pause();
            videoView.seekTo(1);
            bt.setText("شغّل");

        }
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (videoState % 2 == 1)
                        videoView.start();
                }
            });
    }
}