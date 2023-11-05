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
