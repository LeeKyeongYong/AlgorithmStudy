package com.javabook.progmers02;

public class Sample026 { // 문자열 계산하기
	public static void main(String[] args) {
		Solution26 s = new Solution26();
		String my_String = "3 * 4";
		int result = s.solution(my_String);
		System.out.println("문자열 계산 결과: " + result);
	}
}

class Solution26 {
	public int solution(String my_string) {
		int answer = 0;

		String[] strArray = my_string.split(" ");
		answer = Integer.parseInt(strArray[0]);

		for (int i = 1; i < strArray.length; i += 2) {
			if (strArray[i].equals("+")) {
				answer += Integer.parseInt(strArray[i + 1]);
			} else if (strArray[i].equals("*")) {
				answer *= Integer.parseInt(strArray[i + 1]);
			} else if (strArray[i].equals("/")) {
				answer /= Integer.parseInt(strArray[i + 1]);
			} else if (strArray[i].equals("%")) {
				answer %= Integer.parseInt(strArray[i + 1]);
			} else {
				answer -= Integer.parseInt(strArray[i + 1]);
			}
		}

		return answer;
	}
}
