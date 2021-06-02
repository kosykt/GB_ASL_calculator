package com.example.gb_asl_calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Operation implements Parcelable {

    private String num1;
    private String num2;
    private String answer;
    private String symbol;
    private Boolean clickMathOperation = false;
    private Boolean canTouchOpButton = false;

    protected Operation(Parcel in) {
        num1 = in.readString();
        num2 = in.readString();
        answer = in.readString();
        symbol = in.readString();
        byte tmpClickMathOperation = in.readByte();
        clickMathOperation = tmpClickMathOperation == 0 ? null : tmpClickMathOperation == 1;
        byte tmpCanTouchOpButton = in.readByte();
        canTouchOpButton = tmpCanTouchOpButton == 0 ? null : tmpCanTouchOpButton == 1;
        byte tmpCanTouchDotButton = in.readByte();
        canTouchDotButton = tmpCanTouchDotButton == 0 ? null : tmpCanTouchDotButton == 1;
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

    public Boolean getCanTouchDotButton() {
        return canTouchDotButton;
    }

    public void setCanTouchDotButton(Boolean canTouchDotButton) {
        this.canTouchDotButton = canTouchDotButton;
    }

    private Boolean canTouchDotButton = false;

    public Boolean getCanTouchOpButton() {
        return canTouchOpButton;
    }

    public void setCanTouchOpButton(Boolean canTouchOpButton) {
        this.canTouchOpButton = canTouchOpButton;
    }

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
        if (symbol == null) {
            return "Введите выражение";
        }
        switch (symbol) {
            case "+":
                if (num2 != null) {
                    answer = Float.toString(Float.parseFloat(num1) + Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Отсутсвует \nвторое число";
                }
            case "-":
                if (num2 != null) {
                    answer = Float.toString(Float.parseFloat(num1) - Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Отсутсвует \nвторое число";
                }
            case "*":
                if (num2 != null) {
                    answer = Float.toString(Float.parseFloat(num1) * Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Отсутсвует \nвторое число";
                }
            default:
                if (num2 != null) {
                    answer = Float.toString(Float.parseFloat(num1) / Float.parseFloat(num2));
                    symbol = null;
                    return answer;
                } else {
                    return "Отсутсвует \nвторое число";
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(num1);
        dest.writeString(num2);
        dest.writeString(answer);
        dest.writeString(symbol);
        dest.writeByte((byte) (clickMathOperation == null ? 0 : clickMathOperation ? 1 : 2));
        dest.writeByte((byte) (canTouchOpButton == null ? 0 : canTouchOpButton ? 1 : 2));
        dest.writeByte((byte) (canTouchDotButton == null ? 0 : canTouchDotButton ? 1 : 2));
    }
}
