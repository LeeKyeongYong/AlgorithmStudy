package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240406_q1202 {
    static class Product {
        int weight;
        int price;

        public Product(final int weight, final int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Product[] products = new Product[n];
        int[] bags = new int[m];

        for (int i = 0; i < n; i++) {
            products[i] = new Product(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            bags[i] = sc.nextInt();
        }

        // 보석 무게 오른차순 -> 가격 내림차순
        Arrays.sort(products, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }

            return o1.weight - o2.weight;
        });

        // 가방 무게 오름차순
        Arrays.sort(bags);

        // 가격 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        for (int bagIndex = 0, productIndex = 0; bagIndex < m; bagIndex++) {
            // 가방 사이즈에 부합하다면 가격을 모두 넣는다 (가격 : 내림차순)
            while ((productIndex < n) && (products[productIndex].weight <= bags[bagIndex])) {
                pq.offer(products[productIndex].price);
                productIndex++;
            }

            // 가장 큰 가격 넣기
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
