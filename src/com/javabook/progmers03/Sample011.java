package com.javabook.progmers03;

public class Sample011 { //자연수 뒤집어 배열로 만들기
	public static void main(String[] args) {
		Solution012  s = new Solution012();
		int []n = s.solution(12345);
		System.out.print("자연수 뒤집어 배열로 만들기: ");
		for(int i=0; i<n.length; i++) {
			
			if( (n.length-1) == i) {
				System.out.print(n[i]);
			} else {
				System.out.print(n[i]+",");
			}
		}
	}
}

class Solution012{
	//간결하게 푼 소스코드
	public int[] solution(long n) {
		String arrStr = Long.toString(n); //입력받은 long타입을 문자열로 변환한다.
		int[] answer = new int[arrStr.length()]; //변환된 문자열의 길을 answer정답 배열 변수에 담는다.
		
		for(int i=0; i<arrStr.length(); i++) {
			answer[i] = arrStr.charAt(i)-'0'; //가져운 문자 0을 빼서 int형으로 변환 한다음 정답배열에 저장한다.
		}
		return answer;
	}
}


//아무생각없이 푼 소스코드
/*
class Solution012{
	public int[] solution(long n) {
		int lang=(int)Math.log10(n)+1; //자리수 계산
		int[] answer= new int[lang];
		for(int i=lang-1; i>=0; i--) {
			answer[i]=(int)(n%10); //숫자의 일의 자릿수를 추출하여 저장
			n/=10; //숫자를 10으로 나누어 다음 자리수로 이동
		}
		return answer; 
	}
}
*/