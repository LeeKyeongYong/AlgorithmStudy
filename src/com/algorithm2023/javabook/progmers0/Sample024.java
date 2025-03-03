package com.algorithm2023.javabook.progmers0;

public class Sample024 {
	public static void main(String[] args) {
		//String[] solution= {"We","are","the","world!"};
		String[] solution= {"i","Love","Programmers."};
		Solution24 s=new Solution24();
		System.out.println();
		int[] result=s.solution(solution);
		System.out.print("���ڿ��Ǳ���: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
class Solution24 {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        answer=new int[strlist.length];
        for(int i=0; i<strlist.length; i++) {
        	answer[i]=strlist[i].length();
        }
        return answer;
    }
}