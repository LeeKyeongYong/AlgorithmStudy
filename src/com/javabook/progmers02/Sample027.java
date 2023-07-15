package com.javabook.progmers02;

public class Sample027 { // Ox퀴즈
	public static void main(String[] args) {
		String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
		Solution27 s = new Solution27();
		String[] result = s.solution(quiz);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

class Solution27 {
	public String[] solution(String[] quiz) {
		String[] answer = {};
		answer = new String[quiz.length];
		String[] strArray = {};
		for (int i = 0; i < quiz.length; i++) {
			strArray = quiz[i].split(" ");
			int num1 = Integer.parseInt(strArray[0]);
			int num2 = Integer.parseInt(strArray[2]);
			int cal = Integer.parseInt(strArray[4]);
			int result = 0;
			switch (strArray[1]) {
				case "+":
					result = num1 + num2;
					break;
					
				case "-":
					result = num1 - num2;
					break;
					
				case "*":
					result = num1 * num2;
					break;
					
				case "/":
					result = num1 / num2;
					break;
					
				default:
					result = num1 % num2;
					break;
			}
			
			if (result == cal) {
				answer[i] = "O";
			} else {
				answer[i] = "X";
			}
		}
		
		return answer;
	}
}