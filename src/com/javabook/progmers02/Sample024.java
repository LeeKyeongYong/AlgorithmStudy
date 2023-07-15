package com.javabook.progmers02;

public class Sample024 { // 등차수열 합
	public static void main(String[] args) {
		int num = 3;
		int total = 12;
		Solution24 s = new Solution24();
		int[] result = s.solution(num, total);
		System.out.print("등차수열의 합: ");
		for (int i = 0; i < result.length; i++) {
			if (i == result.length - 1) {
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + " , ");
			}
		}
	}
}

class Solution24 {
	public int[] solution(int num, int total) {
		int[] answer = {};
		answer = new int[num];

		int nSum = num * (1 + num) / 2;
		int start = (total - nSum) / num;
		for (int i = 1; i < num + 1; i++) {
			answer[i - 1] = i + start;
		}
		return answer;
	}
}
