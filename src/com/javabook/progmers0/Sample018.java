package com.javabook.progmers0;

import java.util.Scanner;

public class Sample018 {
	public static void main(String[] args) {
		System.out.println("아메리카노를 주문합니다\n급액을 입금해주세요!!!");
		Scanner sc=new Scanner(System.in);
		Solution18 s=new Solution18();
		System.out.print("입금금액: ");
		int money=sc.nextInt();
		int []solution=s.solution(money);
		System.out.print(money+"원은 아이스 아메리카노 "+solution[0]+"잔을 살수있고 잔돈은 "+solution[1]+" 원 입니다.");
	}
}
class Solution18 {
    public int[] solution(int money) {
        int[] answer = {};
        int coffice=5500;
        int nanugi=money/coffice;
        int resultMoney=money%coffice;
        answer=new int[2];
        if(money>0&&money<=1000000) {
        	answer[0]=nanugi;
        	answer[1]=resultMoney;
        }
        return answer;
    }
}