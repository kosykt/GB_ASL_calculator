package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RemoteStartCalculatorTestApp extends AppCompatActivity {

//Подумал вам так легче будет проверить, если здать все одним проектом, нежели раздельно

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_start_calculator_test_app);

        findViewById(R.id.btn_start_calc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("calculator://start");
                Intent calc = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(calc, null));
            }
        });
    }
}