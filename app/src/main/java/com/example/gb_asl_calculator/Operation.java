package com.example.gb_asl_calculator;

public class Operation {

    private Double answer = 0.0;

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }

    public void plusOp (Double n){
        answer += n;
    }

    public void minusOp (Double n){
        answer -= n;
    }

    public void divideOp (Double n){
        answer /= n;
    }

    public void multiplyOp (Double n){
        answer *= n;
    }
}
