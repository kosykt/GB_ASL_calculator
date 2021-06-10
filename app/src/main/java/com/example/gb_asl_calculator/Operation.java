package com.example.gb_asl_calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Operation implements Parcelable {

    private Double num1 = 0.0;
    private Double num2 = 0.0;
    private Double answer = 0.0;
    private String operator = "";
    private Boolean touchNum1Btn = false;
    private Boolean touchOperatorBtn = false;
    private Boolean touchNum2Btn = false;
    private Boolean touchResBtn = false;

    public Operation() {
    }

    public Boolean getTouchNum2Btn() {
        return touchNum2Btn;
    }

    public Boolean getTouchResBtn() {
        return touchResBtn;
    }

    public void setTouchResBtn(Boolean touchResBtn) {
        this.touchResBtn = touchResBtn;
    }

    public void setTouchNum2Btn(Boolean touchNum2Btn) {
        this.touchNum2Btn = touchNum2Btn;
    }

    public void setAnswer(Double answer) {
        this.answer = answer;
    }

    public Double getSaveAnswer(){
        return answer;
    }

    public Double getAnswer() {
        switch (operator) {
            case "+":
                return answer = num1 + num2;
            case "-":
                return answer = num1 - num2;
            case "/":
                return answer = num1 / num2;
            case "*":
                return answer = num1 * num2;
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
        setTouchNum1Btn(true);
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Boolean getTouchNum1Btn() {
        return touchNum1Btn;
    }

    public void setTouchNum1Btn(Boolean touchNumBtn) {
        this.touchNum1Btn = touchNumBtn;
    }

    public Boolean getTouchOperatorBtn() {
        return touchOperatorBtn;
    }

    public void setTouchOperatorBtn(Boolean touchOperatorBtn) {
        this.touchOperatorBtn = touchOperatorBtn;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (num1 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(num1);
        }
        if (num2 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(num2);
        }
        if (answer == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(answer);
        }
        dest.writeString(operator);
        dest.writeByte((byte) (touchNum1Btn == null ? 0 : touchNum1Btn ? 1 : 2));
        dest.writeByte((byte) (touchOperatorBtn == null ? 0 : touchOperatorBtn ? 1 : 2));
    }
    protected Operation(Parcel in) {
        if (in.readByte() == 0) {
            num1 = null;
        } else {
            num1 = in.readDouble();
        }
        if (in.readByte() == 0) {
            num2 = null;
        } else {
            num2 = in.readDouble();
        }
        if (in.readByte() == 0) {
            answer = null;
        } else {
            answer = in.readDouble();
        }
        operator = in.readString();
        byte tmpTouchNumBtn = in.readByte();
        touchNum1Btn = tmpTouchNumBtn == 0 ? null : tmpTouchNumBtn == 1;
        byte tmpTouchOperatorBtn = in.readByte();
        touchOperatorBtn = tmpTouchOperatorBtn == 0 ? null : tmpTouchOperatorBtn == 1;
    }

    public static final Creator<Operation> CREATOR = new Creator<Operation>() {
        @Override
        public Operation createFromParcel(Parcel in) {
            return new Operation(in);
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[size];
        }
    };
}
