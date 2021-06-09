package com.example.gb_asl_calculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextDirectionHeuristics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String keyCounters = "Counters";

    private Operation operation;
    private TextView calculatorView;
    private StringBuffer number1Text = new StringBuffer();
    private StringBuffer number2Text = new StringBuffer();
    private StringBuffer operatorText = new StringBuffer();
    private StringBuffer answerText = new StringBuffer();
    private StringBuffer reserveText = new StringBuffer();
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_dot, button_plus, button_minus, button_divide, button_multiply, button_clear, button_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK){
                    if (result.getData() != null){
                        Toast.makeText(MainActivity.this, result.getData().getStringExtra(ThemeActivity.KEY_RESULT), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        findViewById(R.id.btn_options).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
                resultLauncher.launch(intent);
            }
        });

        operation = new Operation();

        initIdBtn();
        clickBtn();
    }

    private void initIdBtn() {
        calculatorView = findViewById(R.id.calculator_txt);
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
//        button_dot.setOnClickListener(v -> dotBtnText("."));
        button_plus.setOnClickListener(v -> opBtnText("+"));
        button_minus.setOnClickListener(v -> opBtnText("-"));
        button_multiply.setOnClickListener(v -> opBtnText("*"));
        button_divide.setOnClickListener(v -> opBtnText("/"));
        button_result.setOnClickListener(v -> answer());
        button_clear.setOnClickListener(v -> {
            calculatorView.setText("");
            clear();
        });
    }

    private void clear() {
        operation.setNum1(0.0);
        operation.setNum2(0.0);
        operation.setOperator("");
        operation.setTouchNum1Btn(false);
        operation.setTouchOperatorBtn(false);
        operation.setTouchNum2Btn(false);
        operation.setTouchResBtn(false);
        number1Text = new StringBuffer();
        number2Text = new StringBuffer();
        answerText = new StringBuffer();
        operatorText = new StringBuffer();
    }


    private void answer() {
        String s = String.valueOf(operation.getAnswer());
        calculatorView.setText(answerText.append(operation.getAnswer()));
        clear();
        operation.setTouchResBtn(true);
        number1Text.append(s);
        operation.setNum1(Double.valueOf(String.valueOf(number1Text)));
    }

    @SuppressLint("SetTextI18n")
    private void numBtnText(String s) {
        operation.setTouchResBtn(false);
        if (operation.getTouchOperatorBtn()) {
            number2Text.append(s);
            calculatorView.setText(calculatorView.getText() + s);
            operation.setNum2(Double.valueOf(String.valueOf(number2Text)));
            operation.setTouchNum2Btn(true);
        } else {
            number1Text.append(s);
            calculatorView.setText(calculatorView.getText() + s);
            operation.setNum1(Double.valueOf(String.valueOf(number1Text)));
        }
    }

    @SuppressLint("SetTextI18n")
    private void opBtnText(String s) {
        operation.setTouchResBtn(false);
        if (operation.getTouchOperatorBtn()) {
            answer();
        } else {
            calculatorView.setText(calculatorView.getText() + s);
            operatorText.append(s);
            operation.setOperator(s);
            operation.setTouchOperatorBtn(true);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(keyCounters, operation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        operation = instanceState.getParcelable(keyCounters);
        setTextCalculator();
    }

    private void setTextCalculator() {
        if (operation.getTouchNum1Btn()) {
            reserveText.append(operation.getNum1());
            number1Text.append(operation.getNum1());
            calculatorView.setText(reserveText);
            operation.setTouchResBtn(false);
            if (operation.getTouchOperatorBtn()) {
                reserveText.append(operation.getOperator());
                operatorText.append(operation.getOperator());
                calculatorView.setText(reserveText);
                if (operation.getTouchNum2Btn()) {
                    reserveText.append(operation.getNum2());
                    number2Text.append(operation.getNum2());
                    calculatorView.setText(reserveText);

                }
            }
        }
        if (operation.getTouchResBtn()){
            reserveText.append(operation.getSaveAnswer());
            answerText.append(operation.getSaveAnswer());
            calculatorView.setText(reserveText);
        }
    }
}