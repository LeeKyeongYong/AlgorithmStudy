package com.javabook.progmers02;

public class Sample025 { // 사각형 별찍기
	public static void main(String[] args) {
		int m = 2;
		int n = 2;
		Solution25 s = new Solution25();
		int result = s.solution(m, n);
		System.out.println("사각형 별찍기: " + result);
	}
}

class Solution25 {
	public int solution(int M, int N) {
		int answer = 0;
		answer = M * N - 1;
		return answer;
	}
}
