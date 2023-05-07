package com.javabook.progmers0;

import java.util.Arrays;
import java.util.Scanner;

public class Sample020 {
	public static void main(String[] args) {
		Solution20 s=new Solution20();
		//int[] numbers= {1,2,3,4,5};
		int[] numbers= {1,3,5};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("배열 1번째 입력해주세요!!");
		int num1=sc.nextInt();
		System.out.println("배열 2번째 입력해주세요");
		int num2=sc.nextInt();
		
		int[] result = s.solution(numbers, num1, num2);
		System.out.print("잘라진 배열의 길이는??: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
class Solution20 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        answer=new int[num2-num1+1];
        int index=0;
        for(int i=num1; i<num2+1; i++) {
        	answer[index]=numbers[i];
        	index++;
        }
        return answer;
    }
}