package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorView;
    private TextView saveNumView;
    private String saveNum;
    private String saveMathOperation;
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_plus, button_minus, button_divide, button_multiply, button_dot, button_clear, button_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCalculator();
        setNumOnView();
        mathOperations();
    }

    private void mathOperations() {
        button_plus.setOnClickListener(v -> {
            saveNum = (String) calculatorView.getText();
            saveNumView.setText(saveNum);
            saveMathOperation = "+";
            calculatorView.setText(null);
        });
        button_minus.setOnClickListener(v -> {
            saveNum = (String) calculatorView.getText();
            saveNumView.setText(saveNum);
            saveMathOperation = "-";
            calculatorView.setText(null);
        });
        button_divide.setOnClickListener(v -> {
            saveNum = (String) calculatorView.getText();
            saveNumView.setText(saveNum);
            saveMathOperation = "/";
            calculatorView.setText(null);
        });
        button_multiply.setOnClickListener(v -> {
            saveNum = (String) calculatorView.getText();
            saveNumView.setText(saveNum);
            saveMathOperation = "*";
            calculatorView.setText(null);
        });
        button_clear.setOnClickListener(v -> {
            saveNum = null;
            saveNumView.setText(null);
            saveMathOperation = null;
            calculatorView.setText(null);
        });
        button_result.setOnClickListener(v -> {
            saveNum = null;
            saveNumView.setText(null);
            saveMathOperation = null;
            calculatorView.setText(null);
        });
    }

    @SuppressLint("SetTextI18n")
    private void setNumOnView() {
        button_0.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "0"));
        button_1.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "1"));
        button_2.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "2"));
        button_3.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "3"));
        button_4.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "4"));
        button_5.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "5"));
        button_6.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "6"));
        button_7.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "7"));
        button_8.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "8"));
        button_9.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "9"));
        button_dot.setOnClickListener(v -> calculatorView.setText(calculatorView.getText() + "."));
    }

    private void initCalculator() {
        calculatorView = findViewById(R.id.calculator_txt);
        saveNumView = findViewById(R.id.save_num_txt);
        button_0 = findViewById(R.id.btn_0);
        button_1 = findViewById(R.id.btn_1);
        button_2 = findViewById(R.id.btn_2);
        button_3 = findViewById(R.id.btn_3);
        button_4 = findViewById(R.id.btn_4);
        button_5 = findViewById(R.id.btn_5);
        button_6 = findViewById(R.id.btn_6);
        button_7 = findViewById(R.id.btn_7);
        button_8 = findViewById(R.id.btn_8);
        button_9 = findViewById(R.id.btn_9);
        button_plus = findViewById(R.id.btn_plus);
        button_minus = findViewById(R.id.btn_minus);
        button_divide = findViewById(R.id.btn_divide);
        button_multiply = findViewById(R.id.btn_multiply);
        button_dot = findViewById(R.id.btn_dot);
        button_clear = findViewById(R.id.btn_c);
        button_result = findViewById(R.id.btn_result);
    }
}