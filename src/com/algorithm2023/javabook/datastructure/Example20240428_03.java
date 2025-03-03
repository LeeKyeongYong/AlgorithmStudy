package com.algorithm2023.javabook.datastructure;

public class Example20240428_03 {
    public boolean solution(String amountText) {
        boolean hasComma = amountText.contains(",");
        int ind = 1;

        for (int i = amountText.length() - 1; i >= 0; i--) {
            char c = amountText.charAt(i);

            if (ind % 4 == 0) {
                if (hasComma) {
                    if (!isComma(c)) {
                        return false;
                    }
                } else {
                    if (!isNumber(c)) {
                        return false;
                    }
                }
            } else {
                if (!isNumber(c)) {
                    return false;
                }
            }
            ind++;
        }

        if (amountText.length() == 1 && amountText.charAt(0) == '0') {
            return true;
        } else
            return amountText.charAt(0) != '0';
    }

    private boolean isNumber(char now) {
        return '0' <= now && now <= '9';
    }

    private boolean isComma(char now) {
        return now == ',';
    }
}
