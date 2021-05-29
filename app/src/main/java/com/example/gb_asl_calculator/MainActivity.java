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
        Button button_0 = findViewById(R.id.btn_0);
        button_0.setOnClickListener(v -> {
            counter.incrementCounter();
            setTextOnCalculatorView(calculatorView, counter.getCounter());

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