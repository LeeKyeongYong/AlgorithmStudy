package com.javabook.progmers0;

import java.util.Scanner;

public class Sample014 {
	public static void main(String[] args) {
		System.out.println("짝수는 싫어요...\n입력해주세요!!");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution14 s=new Solution14();
		int[] solution=s.solution(n);
		 System.out.print("짝수의 갯수는!!!  ");
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
		System.out.println();
	}
}
class Solution14 {
    public int[] solution(int n) {
        int[] answer = {};
        int sum=0;
        
        	if(n%2==0) {
        		answer=new int[n/2];
        	} else {
        		answer=new int[n/2+1];
        	}
       
        
        for(int i=0; i<=n; i++) {
        	if(i%2==1) {
        		answer[sum]=i;
        		sum++;
        	}
        }
        return answer;
    }
}