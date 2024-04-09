package com.javabook.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Example20240409_q11256 {
	static final Scanner sc = new Scanner(System.in);
	static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			solve();
		}

		System.out.println(sb.toString());
	}

	static void solve() {
		int candy = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[m];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt() * sc.nextInt();
			pq.add(arr[i]);
		}

		int answer = 0;
		while (true) {
			Integer poll = pq.poll();
			candy -= poll;
			answer++;

			if (candy <= 0) {
				break;
			}
		}

		sb.append(answer)
				.append("\n");
	}
}
