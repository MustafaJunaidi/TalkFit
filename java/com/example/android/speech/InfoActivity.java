package com.example.android.speech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.infobar);

        TextView textView = findViewById(R.id.about);
        String texto_html = "توك فِت <b>(TalkFit)</b> هو تطبيق يهدف إلى التدريب على نطق الأصوات العربية، والتأكد من صحة النطق لدى المستخدِم.<br>" +
                "<br>" +
                "يكون التدريب المباشر عن طريق \"<b>المدرِّب</b>\" الذي يستخدم مقطع فيديو توضيحي لآلية نطق الصوت يرافقه تعليمات توضيحية مكتوبة أدنى المقطع.<br>" +
                "<br>" +
                "أما التأكد من صحة نطق الصوت يكون عن طريق \"<b>المصحِّح</b>\"، الذي يُدخِل فيه المستخدم عيّنةً صوتيّةً ليخرُجَ بنتيجة (صواب/خطأ) للمستخدِم، ثم في حال الخطأ ينقله للتدرّب على الصوت.<br>" +
                "<br>" +
                "صُمم هذا التطبيق بصفته مشروعًا لإتمام متطلبات النجاح في مساق (تكنولوجيا أجهزة النطق) <b>بإشراف: د. ضياء السبع</b>.<br>" +
                "<br>" +
                "فكرة ومشروع:<br>" +
                "ليث صالح<br>" +
                "وفية المحتسب<br>" +
                "tec2023speech@gmail.com<br>" +
                "<br>" +
                "<b>برمجة</b>:<br>" +
                "مصطفى الجنيدي<br>" +
                "Mustafaalj2002@gmail.com";
        Spanned spanned = HtmlCompat.fromHtml(texto_html,HtmlCompat.FROM_HTML_MODE_LEGACY);
        textView.setText(spanned);
    }
}