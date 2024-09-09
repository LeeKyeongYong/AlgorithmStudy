package com.jababookbacojoon5;

import java.util.HashMap;
import java.util.Scanner;

public class Example20240909_q9324 {


    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    static void solve() {
        String str = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) == 3) {
                if (i + 1 >= str.length() || str.charAt(i + 1) != c) {
                    System.out.println("FAKE");
                    return;
                }

                i++;
                map.put(c, 0);
            }
        }

        System.out.println("OK");
    }

}
