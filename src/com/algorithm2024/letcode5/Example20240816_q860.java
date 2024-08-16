package com.algorithm2024.letcode5;

public class Example20240816_q860 {
    static int five;
    static int ten;
    static int twenty;

    public boolean lemonadeChange(int[] bills) {
        five = 0;
        ten = 0;
        twenty = 0;

        for (int i : bills) {
            if (i == 5) {
                five++;
                continue;
            }

            if(i == 10) {
                ten++;
            } else if(i == 20) {
                twenty++;
            }

            if (!canReturnedMoney(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean canReturnedMoney(int pay) {
        int money = pay - 5;

        if (money == 5 && five >= 1) {
            five -= 1;
            return true;
        }

        if (money == 15) {
            // 10 5
            if (ten >= 1 && five >= 1) {
                ten--;
                five--;
                return true;
            }

            // 5 5 5
            if (five >= 3) {
                five -= 3;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Example20240816_q860 sol = new Example20240816_q860();

        // true
        System.out.println(sol.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }
}
