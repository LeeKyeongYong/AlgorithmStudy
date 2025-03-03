package com.algorithm2023.javabook.progmers0;

public class Sample019 {
	public static void main(String[] args) {
		 int[] answer = {1,2,3,4,5};
		 Solution19 s=new Solution19();
		 int[] result=s.solution(answer);
		 System.out.println("Ȧ���� ����!!: "+result[0]);
		 System.out.println("¦���� ����!!: "+result[1]);
	}
}

class Solution19 {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        answer=new int[2];
        int hol=0;
        int jjack=0;
        for(int i=0; i<num_list.length; i++) {
        	if(num_list[i]%2==0) {
        		hol++;
        	} else {
        		jjack++;
        	}
        }
        answer[0]=hol;
        answer[1]=jjack;
        return answer;
    }
}