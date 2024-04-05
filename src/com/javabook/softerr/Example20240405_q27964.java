package com.javabook.softerr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example20240405_q27964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> toppingMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String topping = sc.next();

            if (topping.endsWith("Cheese")) {
                toppingMap.put(topping, toppingMap.getOrDefault(topping, 0) + 1);
            }
        }

        if (toppingMap.keySet().size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
