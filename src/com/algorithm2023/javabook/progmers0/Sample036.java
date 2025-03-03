package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample036 {
	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���!! ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("�˻��� ���ڴ�?? ");
		int k=sc.nextInt();
		Solution36 s=new Solution36();
		int result=s.solution(num, k);
		System.out.println("����ã��: "+result);
	}
}
class Solution36 {
    public int solution(int num, int k) {
        int answer = 0;
        String[] strSearch=String.valueOf(num).split("");
        for(int i=0; i<strSearch.length; i++) {
        	if(strSearch[i].equals(String.valueOf(k))) {
        		answer=(i+1);
        		break;
        	} else {
        		answer=-1;
        	}
        }
        return answer;
    }
}