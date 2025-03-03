package com.algorithm2023.javabook.progmers02;

public class Sample029 { // 문자열 배열로 변환하기
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		Solution29 s = new Solution29();
		String[] result = s.solution(my_str, n);
		System.out.print("문자열 배열로 변환 결과: ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

class Solution29 {
	public String[] solution(String my_str, int n) {
		String[] answer = {};

		int cnt = (my_str.length() + n - 1) / n;
		answer = new String[cnt];

		for (int i = 0; i < cnt; i++) {
			int start = n * i;
			int end = 0;
			if (start + n >= my_str.length()) {
				end = my_str.length();
			} else {
				end = start + n;
			}
			answer[i] = my_str.substring(start, end);
		}
		return answer;
	}
}
