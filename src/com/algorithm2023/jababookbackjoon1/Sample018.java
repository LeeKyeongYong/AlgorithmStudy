package com.algorithm2023.jababookbackjoon1;

import java.util.Scanner;

public class Sample018 { //백준 11662번 민호와 강호
	public static void main(String[] args) {
		int ax,ay,bx,by,cx,cy,dx,dy; // 선언받음
		Scanner sc=new Scanner(System.in);
		//선언한 변수를 이용하여 입력받음
		ax = sc.nextInt();
		ay = sc.nextInt();
		bx = sc.nextInt();
		by = sc.nextInt();
		cx = sc.nextInt();
		cy = sc.nextInt();
		dx = sc.nextInt();
		dy = sc.nextInt();
		sc.close();
		
		double result=threeSearch(0,1,ax,ay,bx,by,cx,cy,dx,dy); // 탐색 알고리즘을 사용하여 최단거리 구함
		System.out.printf("%.16fn",result); //결과물 출력
		
	}
	
	public static double threeSearch(double left,double right,int ax,int ay,int bx,int by,int cx,int cy,int dx,int dy) {
		
		while(Math.abs(right-left) > 1e-9) { //현재 구간의 왼쪽과 오른쪽의 구간을 나타낸것을 작아질때까지 반복거리  최단거리 찾음
			
			double left2 = (2*left+right)/3; 
			double right2 =(left+2*right)/3;
			
			if(dist(left2,ax,ay,bx,by,cx,cy,dx,dy) > dist(right2,ax,ay,bx,by,cx,cy,dx,dy)) { 
				left =left2; //선택구간을 왼쪽 업데이트 반복진행처리(최단거리 반환)
			} else { 
				right = right2; //선택구간을 오른쪽 업데이트 반복 진행처리
			}
			
		}
		
		return dist(left,ax,ay,bx,by,cx,cy,dx,dy); // 주어진 값에 따라 좌표계산하고 두점사이의 거리 반환
	}
	public static double dist(double t,int ax,int ay,int bx,int by,int cx,int cy,int dx,int dy) {
		double mx = ax*t+bx*(1-t);
		double my = ay*t+by*(1-t);
		double kx = cx*t+dx*(1-t);
		double ky = cy*t+dy*(1-t);
		return Math.sqrt(Math.pow(kx-mx,2)+Math.pow(ky-my,2));

        
	}
}
/*
문제 >>
민호와 강호가 2차원 좌표 평면 위에 있다. 민호는 점 A(Ax, Ay)에서 점 B(Bx, By)를 향해 걸어가고 있고, 강호는 점 C(Cx, Cy)에서 점 D(Dx, Dy)를 향해 걸어가고 있다. 민호와 강호는 동시에 출발하고, 민호가 점 B에 도착하는 순간 강호도 점 D에 도착한다. 또, 두 사람은 항상 일정한 속도로 걸어간다. 두 사람의 거리가 가장 가까울 때, 거리를 구하는 프로그램을 작성하시오.

두 점 (x1, y1), (x2, y2)사이의 거리는 
\(\sqrt{(x2-x1)^2 + (y2-y1)^2}\) 이다.



입력>>
첫째 줄에 Ax, Ay, Bx, By, Cx, Cy, Dx, Dy가 주어진다. 
입력으로 주어지는 모든 좌표는 0보다 크거나 같고, 
10000보다 작거나 같은 정수이다.

0 0 1 1 2 2 3 3

출력>>
민호와 강호가 가장 가까웠을 때의 거리를 출력한다. 
절대/상대 오차는 10-6까지 허용한다.

2.8284271247


*/