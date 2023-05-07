package com.javabook.progmers0;

import java.util.Scanner;

public class Sample011 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("양꼬치 주문: ");
		int n=sc.nextInt();
		System.out.print("음료수 서비스개수: ");
		int k=sc.nextInt();

		Solution11 s=new Solution11();
		System.out.println("지불해야하는 금액: "+s.solution(n, k));
		sc.close();
	}
}
class Solution11 {
    public int solution(int n, int k) {
        int answer = 0;
        int drink=k*2000;
        int kkochi=n*12000;
        int minus=(n/10)*2000;
        if(n>0&&n<1000) {
        	answer=((drink+kkochi)-minus);
        }
        return answer;
    }
}