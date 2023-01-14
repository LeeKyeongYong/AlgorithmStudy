package com.javabook.progmers;

import java.util.Scanner;

public class Sample006 {
	public static void main(String[] args) {
		Solution6 s=new Solution6();
		System.out.print("나이를 입력해주세요!!!\n 나이입력: ");
		Scanner sc=new Scanner(System.in);
		System.out.println("출생년도: "+s.solution(sc.nextInt()));
		sc.close();
	}
}
class Solution6 {
    public int solution(int age) {
        int answer = 0;
        int year=2022;
        if(age>0&&age<=120){
            answer=(2022-age)+1;
        } 
        return answer;
    }
}