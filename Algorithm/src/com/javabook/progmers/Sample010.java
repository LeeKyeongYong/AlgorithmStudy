package com.javabook.progmers;

import java.util.Scanner;

public class Sample010 {
	public static void main(String[] args) {
		Solution10 s=new Solution10();
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하시오: ");
		int num1=sc.nextInt();
		System.out.print("두번째 정수를 입력하시오: ");
		int num2=sc.nextInt();
		System.out.println("나머지: "+s.solution(num1, num2));
		sc.close();
	}
}
class Solution10 {
    public int solution(int num1, int num2) {
        int answer = -1;
        answer = num1%num2;
        return answer;
    }
}