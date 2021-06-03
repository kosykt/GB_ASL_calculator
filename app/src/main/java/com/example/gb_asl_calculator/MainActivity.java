package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation operation;
    private TextView calculatorView, secondCalculatorView;
    private StringBuffer numbersText = new StringBuffer();
    private StringBuffer answerText = new StringBuffer();
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_dot, button_plus, button_minus, button_divide, button_multiply, button_clear, button_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = new Operation();

        initIdBtn();
        clickBtn();
    }

    private void initIdBtn() {
        calculatorView = findViewById(R.id.calculator_txt);
        secondCalculatorView = findViewById(R.id.save_num_txt);
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
    private void clickBtn() {
        button_0.setOnClickListener(v -> numBtnText("0"));
        button_1.setOnClickListener(v -> numBtnText("1"));
        button_2.setOnClickListener(v -> numBtnText("2"));
        button_3.setOnClickListener(v -> numBtnText("3"));
        button_4.setOnClickListener(v -> numBtnText("4"));
        button_5.setOnClickListener(v -> numBtnText("5"));
        button_6.setOnClickListener(v -> numBtnText("6"));
        button_7.setOnClickListener(v -> numBtnText("7"));
        button_8.setOnClickListener(v -> numBtnText("8"));
        button_9.setOnClickListener(v -> numBtnText("9"));
        button_dot.setOnClickListener(v -> numBtnText("."));
        button_plus.setOnClickListener(v -> opBtnText("+"));
        button_minus.setOnClickListener(v -> opBtnText("-"));
        button_multiply.setOnClickListener(v -> opBtnText("*"));
        button_divide.setOnClickListener(v -> opBtnText("/"));
        button_result.setOnClickListener(v -> answer());
        button_clear.setOnClickListener(v -> {
            clear();
            operation.setOperator("");
        });
    }

    private void clear() {
        calculatorView.setText("");
        secondCalculatorView.setText("");
        numbersText = new StringBuffer();
        answerText = new StringBuffer();
    }

    private void answer() {
        clear();
        secondCalculatorView.setText(answerText.append(operation.getAnswer()));
    }

    private void numBtnText(String s) {
        calculatorView.setText(numbersText.append(s));
        operation.setNum1(Double.valueOf(s));
    }

    private void opBtnText (String s){
        calculatorView.setText(numbersText.append(s));
        operation.setOperator(s);
    }
}