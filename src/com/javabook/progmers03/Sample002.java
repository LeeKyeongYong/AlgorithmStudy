package com.javabook.progmers03;

public class Sample002 { // n 번째 원소부터
	public static void main(String[] args) {
		int[] num_list = {2,1,6};
		int n = 3;
		Solution002 s=new Solution002();
		int[] result = s.solution(num_list, n);
		System.out.print("n번째 원소부터: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+",");
		}
		System.out.println("");
	}
}
class Solution002{
	public int[] solution(int[] num_list,int n) {
		
		int length = num_list.length-n+1; //배열의 길이를 계산한다 
		
		int[] answer = new int[length]; //계산한 배열의 공간을 가지게 된다.
		for(int i=0; i<length; i++) {
			answer[i]= num_list[n++-1]; //n값을 1씩 증가하면서 다음원소를 가져온다.
			//할당된값은 i에 저장된다.
		}
		return answer;
		
	}
}