package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation operation;
    private TextView calculatorView, secondCalculatorView;
    private StringBuffer reserveText = new StringBuffer("");
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
        button_0.setOnClickListener(v -> setBtnText("0"));
        button_1.setOnClickListener(v -> setBtnText("1"));
        button_2.setOnClickListener(v -> setBtnText("2"));
        button_3.setOnClickListener(v -> setBtnText("3"));
        button_4.setOnClickListener(v -> setBtnText("4"));
        button_5.setOnClickListener(v -> setBtnText("5"));
        button_6.setOnClickListener(v -> setBtnText("6"));
        button_7.setOnClickListener(v -> setBtnText("7"));
        button_8.setOnClickListener(v -> setBtnText("8"));
        button_9.setOnClickListener(v -> setBtnText("9"));
        button_dot.setOnClickListener(v -> setBtnText("."));
        button_plus.setOnClickListener(v -> setBtnText("+"));
        button_minus.setOnClickListener(v -> setBtnText("-"));
        button_multiply.setOnClickListener(v -> setBtnText("*"));
        button_divide.setOnClickListener(v -> setBtnText("/"));
        button_result.setOnClickListener(v -> answer());
        button_clear.setOnClickListener(v -> {
            clear();
        });
    }

    private void clear() {
        calculatorView.setText("");
        secondCalculatorView.setText("");
        reserveText = new StringBuffer("");
        operation.setNum(null);
        operation.setAnswer(null);
    }

    private void answer() {
        operation.setNum(reserveText);
        clear();
        secondCalculatorView.setText(reserveText.append(operation.getAnswer()));
    }

    private void setBtnText(String s) {
        reserveText.append(s);
        calculatorView.setText(reserveText);
    }
}