package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample009 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution9 s=new Solution9();
		System.out.print("�Է��Ͻ� �������� ���� �Է����ּ���: ");
		int angle=sc.nextInt();
		int result=s.solution(angle);
		sc.close();
		String gakdo="";
		if(result==1) {
			gakdo="����";
		} else if(result==2) {
			gakdo="����";
		} else if(result==3) {
			gakdo="�а�";
		} else {
			gakdo="��";
		}
		System.out.println("�Է��Ͻ� ����"+angle+" �� "+gakdo+" �Դϴ�.");
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