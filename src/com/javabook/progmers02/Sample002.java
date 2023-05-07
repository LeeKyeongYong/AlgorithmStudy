package com.javabook.progmers02;

public class Sample002 {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4};
		int k=2;
		Solution002 s=new Solution002();
		int solution=s.solution(numbers,k);
		System.out.println("result: "+solution);
	}
}
class Solution002 {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        answer=numbers[2*(k-1)%numbers.length];
        return answer;
    }
}