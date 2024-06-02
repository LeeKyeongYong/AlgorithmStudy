package com.algorithm2024.letcode3;

public class Example20240602_q344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        char[] a={'A','B'};
        new Example20240602_q344().reverseString(a);
        System.out.println(a);
    }
}
