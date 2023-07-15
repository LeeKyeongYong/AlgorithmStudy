package com.javabook.progmers02;

public class Sample021 { // 테스트 코드 작성
	public static void main(String[] args) {
		Solution021 s = new Solution021();
		String result = s.solution("abcbcdc");
		System.out.println("결과 문자열: " + result);
	}
}

class Solution021 {
	public String solution(String s) {
		String answer = "";
		int[] strArr = new int[26];
		for (int i = 0; i < strArr.length; i++) { // 배열을 0으로 초기화
			strArr[i] = 0;
		}

		for (int i = 0; i < s.length(); i++) { // 반복문을 사용하여 문자의 등장 횟수를 배열에 저장
			strArr[s.charAt(i) - 97] += 1;
		}

		for (int i = 0; i < 26; i++) {
			if (strArr[i] == 1) { // 등장 횟수가 1인 문자만 선택하여 결과에 추가
				answer += (char) (i + 97);
			}
		}

		return answer;
	}
}
