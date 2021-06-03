package com.example.gb_asl_calculator;

public class Operation {

    private Double num1 = 0.0;
    private Double num2 = 0.0;
    private String operator = "";
    private Boolean touchNumBtn = false;
    private Boolean touchOperatorBtn = false;

    public Operation() {
    }

    public Double getAnswer() {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "/":
                return num1 / num2;
            case "*":
                return num1 * num2;
            default:
                return 1.0101;
        }
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Boolean getTouchNumBtn() {
        return touchNumBtn;
    }

    public void setTouchNumBtn(Boolean touchNumBtn) {
        this.touchNumBtn = touchNumBtn;
    }

    public Boolean getTouchOperatorBtn() {
        return touchOperatorBtn;
    }

    public void setTouchOperatorBtn(Boolean touchOperatorBtn) {
        this.touchOperatorBtn = touchOperatorBtn;
    }
}
