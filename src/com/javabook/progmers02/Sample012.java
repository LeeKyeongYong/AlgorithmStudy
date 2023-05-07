package com.javabook.progmers02;

public class Sample012 {//n의 배수 고르기
	public static void main(String[] args) {
		Solution12 s=new Solution12();
		int[] numbers= {4, 5, 6, 7, 8, 9, 10, 11, 12};
		int n = 3;
		int[] solution=s.solution(n, numbers);
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
		System.out.println();
	}
}
class Solution12 {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        int cnt=0;
        int num=0;
        for(int i=0; i<numlist.length; i++) {
        	if(numlist[i]%n==0) {
        		num++;
        	}
        }
        answer=new int[num];
        for(int i=0; i<numlist.length; i++) {
        	if(numlist[i]%n==0) {
        		answer[cnt]=numlist[i];
        		cnt++;
        	}
        }
        return answer;
    }
}