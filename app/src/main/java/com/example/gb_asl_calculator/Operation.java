package com.example.gb_asl_calculator;

public class Operation {

    public String plusOp (String n1, String n2){
        return Float.toString(Float.parseFloat(n1) + Float.parseFloat(n2));
    }

    public String minusOp (String n1, String n2){
        return Float.toString(Float.parseFloat(n1) - Float.parseFloat(n2));
    }

    public String multiplyOp (String n1, String n2){
        return Float.toString(Float.parseFloat(n1) * Float.parseFloat(n2));
    }

    public String divideOp (String n1, String n2){
        return Float.toString(Float.parseFloat(n1) / Float.parseFloat(n2));
    }
}
