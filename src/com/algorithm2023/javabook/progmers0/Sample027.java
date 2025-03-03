package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample027 {
	public static void main(String[] args) {
		System.out.println("�ӽ����� ���� ��: ");
		Scanner sc=new Scanner(System.in);
		int price=sc.nextInt();
		Solution27 s=new Solution27();
		int result=s.solution(price);
		System.out.println("���ε� �ݾ���??: "+result);
	}
}

class Solution27 {
    public int solution(int price) {
        int answer = 0;
        if(price>=10&&price<=1000000) {
	        if(price>=500000) {
	        	answer=(int)(price*0.8);
	        } else if(price>=300000) {
	        	answer=(int) (price*0.9);
	        } else if(price>=100000) {
	        	answer=(int) (price*0.95);
	        } else {
	        	answer=price;
	        }
        }
        return answer;
    }
}