package com.example.gb_asl_calculator;

public class Operation {

    private String num1;
    private String num2;
    private String answer;
    private String symbol;
    private Boolean clickMathOperation = false;

    public Operation() {
        this.num1 = null;
        this.num2 = null;
        this.answer = null;
        this.symbol = null;
    }

    public Boolean getClickMathOperation() {
        return clickMathOperation;
    }

    public void setClickMathOperation(Boolean clickMathOperation) {
        this.clickMathOperation = clickMathOperation;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getAnswer() {
        if (symbol == null){
            return "нет оператора";
        }
        switch (symbol) {
            case "+":
                if (num1 != null && num2 != null){
                    answer = Float.toString(Float.parseFloat(num1) + Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Нет чисел";
                }
            case "-":
                if (num1 != null && num2 != null){
                    answer = Float.toString(Float.parseFloat(num1) - Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Нет чисел";
                }
            case "*":
                if (num1 != null && num2 != null){
                    answer = Float.toString(Float.parseFloat(num1) * Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Нет чисел";
                }
            default:
                if (num1 != null && num2 != null){
                    answer = Float.toString(Float.parseFloat(num1) / Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Нет чисел";
                }
        }
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
