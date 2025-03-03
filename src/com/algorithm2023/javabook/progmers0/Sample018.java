package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample018 {
	public static void main(String[] args) {
		System.out.println("�Ƹ޸�ī�븦 �ֹ��մϴ�\n�޾��� �Ա����ּ���!!!");
		Scanner sc=new Scanner(System.in);
		Solution18 s=new Solution18();
		System.out.print("�Աݱݾ�: ");
		int money=sc.nextInt();
		int []solution=s.solution(money);
		System.out.print(money+"���� ���̽� �Ƹ޸�ī�� "+solution[0]+"���� ����ְ� �ܵ��� "+solution[1]+" �� �Դϴ�.");
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