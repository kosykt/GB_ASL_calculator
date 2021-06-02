package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation operation;

    private TextView calculatorView, saveNumView;
    private String subText;
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_dot, button_plus, button_minus, button_divide, button_multiply, button_clear, button_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = new Operation();

        initCalculator();
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
        setNumOnView();
    }

    private void setNumOnView() {
        button_0.setOnClickListener(v -> setNumInOperationClass("0"));
        button_1.setOnClickListener(v -> setNumInOperationClass("1"));
        button_2.setOnClickListener(v -> setNumInOperationClass("2"));
        button_3.setOnClickListener(v -> setNumInOperationClass("3"));
        button_4.setOnClickListener(v -> setNumInOperationClass("4"));
        button_5.setOnClickListener(v -> setNumInOperationClass("5"));
        button_6.setOnClickListener(v -> setNumInOperationClass("6"));
        button_7.setOnClickListener(v -> setNumInOperationClass("7"));
        button_8.setOnClickListener(v -> setNumInOperationClass("8"));
        button_9.setOnClickListener(v -> setNumInOperationClass("9"));
        mathOperations();
    }

    @SuppressLint("SetTextI18n")
    private void setNumInOperationClass(String s) {
        if (operation.getClickMathOperation().equals(false)) {
            calculatorView.setText(calculatorView.getText() + s);
            operation.setNum1((String) calculatorView.getText());
        } else {
            calculatorView.setText(calculatorView.getText() + s);
            if (subText == null) {
                subText = s;
            } else {
                subText = subText + s;
            }
            operation.setNum2(subText);
        }
    }

    private void mathOperations() {
        button_plus.setOnClickListener((View v) -> mathOperationLogic("+"));
        button_minus.setOnClickListener((View v) -> mathOperationLogic("-"));
        button_multiply.setOnClickListener((View v) -> mathOperationLogic("*"));
        button_divide.setOnClickListener((View v) -> mathOperationLogic("/"));
        button_result.setOnClickListener(v -> resultOperation());
        button_clear.setOnClickListener(v -> {
            saveNumView.setText(null);
            calculatorView.setText(null);
            subText = null;
            operation.setSymbol(null);
            operation.setNum1(null);
            operation.setNum2(null);
            operation.setAnswer(null);
            operation.setClickMathOperation(false);
        });
    }

    @SuppressLint("SetTextI18n")
    private void mathOperationLogic(String s) {
        if (operation.getClickMathOperation().equals(true)) {
            resultOperation();
        } else {
            operation.setClickMathOperation(true);
        }
        calculatorView.setText(calculatorView.getText() + s);
        operation.setSymbol(s);
    }

    private void resultOperation() {
        calculatorView.setText(operation.getAnswer());
        subText = null;
    }
}