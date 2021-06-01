package com.example.gb_asl_calculator;

public class Operation {

    private String num1;
    private String num2;
    private String answer;
    private String symbol;

    public Operation() {
        this.num1 = null;
        this.num2 = null;
        this.answer = null;
        this.symbol = null;
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
        if (symbol.equals("+")){
            return "+";
        }else {
            return "";
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

//    public String plusOp (String n1, String n2){
//        return Float.toString(Float.parseFloat(n1) + Float.parseFloat(n2));
//    }
//
//    public String minusOp (String n1, String n2){
//        return Float.toString(Float.parseFloat(n1) - Float.parseFloat(n2));
//    }
//
//    public String multiplyOp (String n1, String n2){
//        return Float.toString(Float.parseFloat(n1) * Float.parseFloat(n2));
//    }
//
//    public String divideOp (String n1, String n2){
//        return Float.toString(Float.parseFloat(n1) / Float.parseFloat(n2));
//    }
}
