package com.javabook.progmers0;

import java.util.Scanner;

public class Sample036 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요!! ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("검색할 숫자는?? ");
		int k=sc.nextInt();
		Solution36 s=new Solution36();
		int result=s.solution(num, k);
		System.out.println("숫자찾기: "+result);
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