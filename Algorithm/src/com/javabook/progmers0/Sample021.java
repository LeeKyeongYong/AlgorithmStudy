package com.javabook.progmers0;

import java.util.Scanner;

public class Sample021 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution21 s=new Solution21();
		System.out.println("X 좌표입력: ");
		int numX=sc.nextInt();
		System.out.println("Y 좌표 입력: ");
		int numY=sc.nextInt();
		int[] dot=new int[2];
		dot[0]=numX;
		dot[1]=numY;
		int result=s.solution(dot);
		System.out.println("dot의 원소는 "+result+" 입니다");
	}
}
class Solution21 {
    public int solution(int[] dot) {
        int answer = 0;
        answer=dot[0]>0&&dot[1]>0?1:dot[0]<0&&dot[1]>0?2:dot[0]<0&&dot[1]<0?3:dot[0]>0&&dot[1]<0?4:0;
        return answer;
    }
}