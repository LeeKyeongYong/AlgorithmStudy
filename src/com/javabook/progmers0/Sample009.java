package com.javabook.progmers0;

import java.util.Scanner;

public class Sample009 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution9 s=new Solution9();
		System.out.print("입력하실 각도기의 각도 입력해주세요: ");
		int angle=sc.nextInt();
		int result=s.solution(angle);
		sc.close();
		String gakdo="";
		if(result==1) {
			gakdo="예각";
		} else if(result==2) {
			gakdo="직각";
		} else if(result==3) {
			gakdo="둔각";
		} else {
			gakdo="평각";
		}
		System.out.println("입력하신 각도"+angle+" 은 "+gakdo+" 입니다.");
	}
}
class Solution9 {
    public int solution(int angle) {
        int answer = 0;
        if(angle>0&&angle<90) {
        	answer = 1;
        } else if(angle==90) {
        	answer = 2;
        } else if(angle > 90 && angle<180) {
        	answer = 3;
        } else {
        	answer = 4;
        }
        return answer;
    }
}