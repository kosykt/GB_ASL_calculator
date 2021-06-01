package com.example.gb_asl_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation operation;

    private Boolean clickMathOperation = false;
    private TextView calculatorView, saveNumView;
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_dot, button_plus, button_minus, button_divide, button_multiply, button_clear, button_result;
//    private final Button[] numButtonsArr = new Button[]{button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9};
//    private final int[] numberButtonIds = new int[]{R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = new Operation();

        initCalculator();
        setNumOnView();
        mathOperations();
    }

    @SuppressLint("SetTextI18n")
    private void mathOperations() {
        button_plus.setOnClickListener((View v) -> {
            clickMathOperation = true;
            operation.setSymbol("+");
            calculatorView.setText(calculatorView.getText() + "+");
            saveNumView.setText(operation.getSymbol());
        });
        button_minus.setOnClickListener((View v) -> {
            clickMathOperation = true;
            operation.setSymbol("-");
            calculatorView.setText(calculatorView.getText() + "-");
            saveNumView.setText(operation.getSymbol());
        });
        button_divide.setOnClickListener((View v) -> {
            clickMathOperation = true;
            operation.setSymbol("/");
            calculatorView.setText(calculatorView.getText() + "/");
            saveNumView.setText(operation.getSymbol());
        });
        button_multiply.setOnClickListener((View v) -> {
            clickMathOperation = true;
            operation.setSymbol("*");
            calculatorView.setText(calculatorView.getText() + "*");
            saveNumView.setText(operation.getSymbol());
        });
//        button_clear.setOnClickListener(v -> {
//            saveNum = null;
//            saveNumView.setText(null);
//            saveMathOperation = null;
//            calculatorView.setText(null);
//        });
//        button_result.setOnClickListener(v -> {
//            if (saveMathOperation.equals("+")){
//                saveNumView.setText(operation.plusOp(saveNum, String.valueOf(calculatorView.getText())));
//            }
//            if (saveMathOperation.equals("-")){
//                saveNumView.setText(operation.minusOp(saveNum, String.valueOf(calculatorView.getText())));
//            }
//            if (saveMathOperation.equals("*")){
//                saveNumView.setText(operation.multiplyOp(saveNum, String.valueOf(calculatorView.getText())));
//            }
//            if (saveMathOperation.equals("/")){
//                saveNumView.setText(operation.divideOp(saveNum, String.valueOf(calculatorView.getText())));
//            }
//            calculatorView.setText(null);
//        });
    }

    private void setNumInOperationClass(){
        if (clickMathOperation.equals(false)){
            operation.setNum1((String) calculatorView.getText());
        } else {
            operation.setNum2((String) calculatorView.getText());
        }
    }

    @SuppressLint("SetTextI18n")
    private void setNumOnView() {
        button_0.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "0");
            setNumInOperationClass();
        });
        button_1.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "1");
            setNumInOperationClass();
        });
        button_2.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "2");
            setNumInOperationClass();
        });
        button_3.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "3");
            setNumInOperationClass();
        });
        button_4.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "4");
            setNumInOperationClass();
        });
        button_5.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "5");
            setNumInOperationClass();
        });
        button_6.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "6");
            setNumInOperationClass();
        });
        button_7.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "7");
            setNumInOperationClass();
        });
        button_8.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "8");
            setNumInOperationClass();
        });
        button_9.setOnClickListener(v -> {
            calculatorView.setText(calculatorView.getText() + "9");
            setNumInOperationClass();
        });
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