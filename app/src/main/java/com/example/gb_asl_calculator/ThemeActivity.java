package com.example.gb_asl_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity {

    public static final String KEY_RESULT = "KEY_RESULT";
    public static final String KEY_TEXT_TO_DISPLAY = "KEY_TEXT_TO_DISPLAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        findViewById(R.id.btn_standart_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_RESULT, "btn_standart_theme");

                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });

        findViewById(R.id.btn_mystyle_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_RESULT, "btn_btn_mystyle_theme");

                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });

        findViewById(R.id.btn_mystyle_night_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_RESULT, "btn_mystyle_night_theme");

                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}