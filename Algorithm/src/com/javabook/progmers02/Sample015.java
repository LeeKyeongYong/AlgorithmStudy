package com.javabook.progmers02;

public class Sample015 {//약수구하기
	public static void main(String[] args) {
		int n=24;
		Solution15 s=new Solution15();
		int[] solution=s.solution(n);
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution15 {
    public int[] solution(int n) {
        int[] answer = {};
        int count=0;
        int[] array= new int[n];
        
        for(int i=1; i<=n; i++) {
        	if(n%i==0) { //약수인만큼 카운트 처리
        		array[count]=i;
        		count++;
        	}
        }
        answer = new int[count]; //답안을 작성하기위해 배열 생성 시작한다.
        for(int i=0; i<count; i++) {
        	if(array[i]!=0) { //약수인만큼 카운트 처리
        		answer[i]=array[i];
        	}
        }
        
        return answer;
    }
}