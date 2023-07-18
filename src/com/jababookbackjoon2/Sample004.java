package com.jababookbackjoon2;

import java.util.Scanner;

public class Sample004 { //백준 2558번 A+B2 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int a,b; //변수를 선언한다
		
		a=sc.nextInt(); //선언한 변수를 대입한다.
		b=sc.nextInt(); //선언한 변수를 대입한다.
		
		sc.close(); //scanner종료한다.
		System.out.println(a+b); //변수의 값을 덧셈한다.
	}
}
/*
문제>>
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력>>
첫째 줄에 A, 둘째 줄에 B가 주어진다. (0 < A, B < 10)
1
2

출력>>
3

*/