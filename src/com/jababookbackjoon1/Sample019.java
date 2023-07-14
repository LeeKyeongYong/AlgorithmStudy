package com.jababookbackjoon1;

import java.util.Scanner;

public class Sample019 { //백준 7869 두원
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		double x1,y1,r1,x2,y2,r2; //선언
		
		//선언한 변수 입력하기
		x1 = sc.nextDouble();
		y1 = sc.nextDouble();
		r1 = sc.nextDouble();
		x2 = sc.nextDouble();
		y2 = sc.nextDouble();
		r2 = sc.nextDouble();
		
		sc.close();
		
		double result = area(x1,y1,r1,x2,y2,r2); // 메서도 호출
		System.out.printf("%.3fn",result); //호출한 메서드의 반환한 결과값 출력
	}
	
	public static double area(double x1,double y1,double r1,double x2,double y2, double r2) {
		
		double d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		double rr1 = r1 * r1;
		double rr2 = r2 * r2;
		
		if(d>r2+r1) {
			return 0; //원이 겹치지 않음
		} else if(d<=Math.abs(r1-r2)&&r1<r2) {//원1이 내부에
			return Math.PI * rr1;
		} else if(d<=Math.abs(r1-r2)&&r1>=r2) { //원2이 내부에
			return Math.PI*rr2;
		} else { //두 점에서 만나는 경우
			double phi = (Math.acos((rr1+(d*d)-rr2)/(2*r1*d)))*2; //삼각형의 각도 삼각법 공식을 사용하여 계산
			double theta = (Math.acos((rr2+(d*d)-rr1)/(2*r2*d)))*2; //삼각형의 각도 삼각법 공식을 사용하여 계산
			double area1 = 0.5*rr2*(theta-Math.sin(theta)); //삼각형의 넓이 원 1에서 만난 부분면적
			double area2 = 0.5*rr1*(phi-Math.sin(phi)); //삼각형의 넓이 원2에서 만나는 부분 면적
			return area1+area2; //면적의 덧셈으로 반환처리
		}
	}
}
/*
문제>>
두 원이 주어졌을 때, 교차하는 영역의 넓이를 소수점 셋째자리까지 구하는 프로그램을 작성하시오.

입력>>
첫째 줄에 두 원의 중심과 반지름 x1, y1, r1, x2, y2, r2가 주어진다. 실수는 최대 소수점 둘째자리까지 주어진다.
20.0 30.0 15.0 40.0 30.0 30.0

출력>>
첫째 줄에 교차하는 영역의 넓이를 반올림해 소수점 셋째자리까지 출력한다.
608.366

*/