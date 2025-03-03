package com.algorithm2023.javabook.progmers0;

public class Sample022 {
	public static void main(String[] args) {
		Solution22 s=new Solution22();
		int[] num_list= {1,2,3,4,5};
		int[] reusult=s.solution(num_list);
		System.out.println("�迭 ���!! ");
		for(int i=0; i<reusult.length; i++) {
			System.out.print(reusult[i]+" ");
		}
	}
}
class Solution22 {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int[] revers=new int[num_list.length];
        answer=new int[num_list.length];
        for(int i=0; i<num_list.length; i++) {
        	int temp=num_list[i];
        	revers[i]=num_list[num_list.length-i-1];
        	answer[num_list.length-i-1]=temp;
		}
        return answer;
    }
}