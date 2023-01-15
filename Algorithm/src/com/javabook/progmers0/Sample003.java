package com.javabook.progmers0;

public class Sample003 {
	public static void main(String[] args) {
		Solution3 s=new Solution3();
		int numbers[]= {1,2,3,4,5};
		//System.out.println(s.solution(numbers));
		int result[]=s.solution(numbers);
		int sum=0;
		for(int i=0; i<result.length; i++) {
			System.out.println("배열출력값: "+result[i]);
			sum+=result[i];
		}
		System.out.println("배열합계: "+sum);
	}
}
class Solution3 {
    public int[] solution(int[] numbers) {
          int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
          answer[i]=(numbers[i]*2);
        }
         return answer;
    }
}