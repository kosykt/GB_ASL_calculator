package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView calculatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
    }

    private void initView() {
        calculatorView = findViewById(R.id.calculator_txt);
        Button button_0 = findViewById(R.id.btn_0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                setTextOnCalculatorView(calculatorView, counter);

            }
        });
    }

    private void setTextOnCalculatorView(TextView view, int num) {
        view.setText(String.format(Locale.getDefault(), "%d", num));
    }
}