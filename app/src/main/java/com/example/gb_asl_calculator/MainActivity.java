package com.example.gb_asl_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final static String keyCounter = "Counter";

    private Counter counter;
    private TextView calculatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = new Counter();
        initView();
    }

    private void initView() {
        calculatorView = findViewById(R.id.calculator_txt);

        initButton_0();
        initButton_1();
        initButton_2();
        initButton_3();
        initButton_4();
        initButton_5();
        initButton_6();
        initButton_7();
        initButton_8();
        initButton_9();
    }

    private void initButton_9() {
        Button button_9 = findViewById(R.id.btn_9);
        button_9.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_8() {
        Button button_8 = findViewById(R.id.btn_8);
        button_8.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_7() {
        Button button_7 = findViewById(R.id.btn_7);
        button_7.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_6() {
        Button button_6 = findViewById(R.id.btn_6);
        button_6.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_5() {
        Button button_5 = findViewById(R.id.btn_5);
        button_5.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_4() {
        Button button_4 = findViewById(R.id.btn_4);
        button_4.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_3() {
        Button button_3 = findViewById(R.id.btn_3);
        button_3.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_2() {
        Button button_2 = findViewById(R.id.btn_2);
        button_2.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_1() {
        Button button_1 = findViewById(R.id.btn_1);
        button_1.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void initButton_0() {
        Button button_0 = findViewById(R.id.btn_0);
        button_0.setOnClickListener(v -> {
            counter.incrementCounter();
            MainActivity.this.setTextOnCalculatorView(calculatorView, counter.getCounter());
        });
    }

    private void setTextOnCalculatorView(TextView view, int num) {
        view.setText(String.format(Locale.getDefault(), "%d", num));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCounter, counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        counter = instanceState.getParcelable(keyCounter);
        setTextCounter();
    }

    private void setTextCounter() {
        setTextOnCalculatorView(calculatorView, counter.getCounter());
    }
}