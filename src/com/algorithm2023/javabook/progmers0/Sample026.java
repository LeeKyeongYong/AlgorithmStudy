package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample026 {
	public static void main(String[] args) {
		Solution26 s=new Solution26();
		//int array[]= {149,180,192,170};
		int array[]= {180,120,140};
		Scanner sc=new Scanner(System.in);
		System.out.print("�Ӿ����� Ű�� ���غ�����..: ");
		int height=sc.nextInt();
		int result=s.solution(array, height);
		System.out.println("�ӽ��̴� ���ǿ��� "+result+" ��° Ű�� Ů�ϴ�.");
	}
}
class Solution26 {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int i=0; i<array.length; i++) {
        	if(array[i]>height) {
        		answer++;
        	}
        }
        return answer;
    }
}