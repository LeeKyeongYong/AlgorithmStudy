package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample010 {
	public static void main(String[] args) {
		Solution10 s=new Solution10();
		Scanner sc=new Scanner(System.in);
		System.out.print("ù��° ������ �Է��Ͻÿ�: ");
		int num1=sc.nextInt();
		System.out.print("�ι�° ������ �Է��Ͻÿ�: ");
		int num2=sc.nextInt();
		System.out.println("������: "+s.solution(num1, num2));
		sc.close();
	}
}
class Solution10 {
    public int solution(int num1, int num2) {
        int answer = -1;
        answer = num1%num2;
        return answer;
    }
}