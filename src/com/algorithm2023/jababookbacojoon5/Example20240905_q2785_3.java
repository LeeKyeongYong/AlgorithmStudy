package com.algorithm2023.jababookbacojoon5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240905_q2785_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> chain = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            chain.add(sc.nextInt());
        }

        Collections.sort(chain);

        // 3 4 5 7 9
        int answer = 0;
        while (chain.size() > 1) {
            chain.set(0, chain.get(0) - 1);
            chain.remove(chain.size() - 1);

            if (chain.get(0) == 0) {
                chain.remove(0);
            }

            answer++;
        }

        System.out.println(answer);
    }

}
