package com.javabook.progmers0;

import java.util.Scanner;

public class Sample017 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇명이 먹을예정인가요? ");
		int n=sc.nextInt();
		System.out.println("몇조각을 할예정인가요??");
		int slice=sc.nextInt();
		
		Solution17 s=new Solution17();
		int result=s.solution(slice, n);
		System.out.println("최소 "+result+" 판을 먹을수있습니다.");
		
	}
}
class Solution17 {
    public int solution(int slice, int n) {
        int answer = 0;
        if(n%slice==0) {
        	answer=n/slice;
        } else {
        	answer=n/slice+1;
        }
        return answer;
    }
}