package com.jababookbackjoon2;

import java.util.Scanner;

public class Sample000 { //백준 1297 TV크기
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); //scanner생성
		
		int diagonal=sc.nextInt(); //대각선의길이 받아 변수에 대입
		
		int heightRatio=sc.nextInt(); //높이비율 받아 변수에 대입
		
		int widthRatio=sc.nextInt(); //넓이 비율 받아 변수에 대입
		
		sc.close();//scanner종료
		
		double x = Math.sqrt((double)(diagonal*diagonal)/(heightRatio*heightRatio+widthRatio*widthRatio));
		//입력 받은 값들을 사용하여 계산을 수행
		//대각선의 길이의 제곱을 높이와 너비 비율의 제곱의 합으로 나눈 값을 계산
		//구한 값을 제곱근으로 계산하여 x에 대입
		
		int height=(int)Math.floor(heightRatio*x); //heightRatio와 x를 곱한 뒤 내림한 값을 계산
		
		int width=(int)Math.floor(widthRatio*x); //widthRatio와 x를 곱한 뒤 내림한 값을 계산
		
		System.out.println(height+" "+width); //계산된 높이와 넓이값 출력
		
		
	}
}
/*
 문제>>
 
 김탑은 TV를 사러 인터넷 쇼핑몰에 들어갔다. 
 쇼핑을 하던 중에, TV의 크기는 그 TV의 대각선의 길이로 나타낸 다는 것을 알았다. 
 하지만, 김탑은 대각선의 길이가 같다고 해도, 실제 TV의 크기는 다를 수도 있다는 
 사실에 직접 TV를 보러갈걸 왜 인터넷 쇼핑을 대각선의 길이만 보고있는지 후회하고 있었다.
 인터넷 쇼핑몰 관리자에게 이메일을 보내서 실제 높이와 실제 너비를 보내달라고 했지만, 
 관리자는 실제 높이와 실제 너비를 보내지 않고 그것의 비율을 보내왔다.
 TV의 대각선 길이와, 높이 너비의 비율이 주어졌을 때, 
 실제 높이와 너비의 길이를 출력하는 프로그램을 작성하시오.
 
 입력>>
 첫째 줄에 TV의 대각선 길이 D, TV의 높이 비율 H, TV의 너비 비율 W이 공백 한 칸을 사이에 두고 주어진다.
 52 9 16
 
 출력>>
 첫째 줄에 TV의 높이와 TV의 너비를 공백 한 칸을 이용해서 구분지은 후 출력한다. 
 만약, 실제 TV의 높이나 너비가 소수점이 나올 경우에는 그 수보다 작으면서 가장 큰 정수로 출력한다. 
 (예) 1.7 -> 1
 
 25 45
 
*/