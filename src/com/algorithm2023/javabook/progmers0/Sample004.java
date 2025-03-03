package com.algorithm2023.javabook.progmers0;

public class Sample004 {
	public static void main(String[] args) {
		Solution4 s=new Solution4();
		
		//int []result=s.solution(9,2,1,3);
		int []result=s.solution(1,2,3,4);
		
		for(int i=0; i<result.length; i++) {
			System.out.println("�����: "+result[i]);
		}
				
	}
}
class Solution4 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int footNumer=denom1*denom2;//�и�
        int topNumer=numer1*denom2+numer2*denom1;//����
        int maxNum=1;//�ּ� �����
        for(int i=1; i<=footNumer&&i<=topNumer; i++) { //���
        	if(footNumer%i==0&&topNumer%i==0) {
        		maxNum=i;
        	}
        }
        answer[0]=topNumer/maxNum;
        answer[1]=footNumer/maxNum;
        return answer;
    }
}