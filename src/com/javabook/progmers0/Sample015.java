package com.javabook.progmers0;

import java.util.Scanner;

public class Sample015 {
	public static void main(String[] args) {
		Solution15 s=new Solution15();
		System.out.print("몇명이 피자를 드실건가요? ");
		Scanner sc=new Scanner(System.in);
		int pisa=sc.nextInt();
		int n=s.solution(pisa);
		System.out.println("피자 몇판??: "+n);
	}
}
class Solution15 {
    public int solution(int n) {
        int answer = 0;
        int pan=n/7;
        int moc=n%7;
        if(moc==0) {
            answer=pan*1;
        } else {
            answer=(pan*1+1);
        }
        return answer;
    }
}