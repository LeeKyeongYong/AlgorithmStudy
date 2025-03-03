package com.algorithm2023.javabook.progmers02;

public class Sample043 {//특정 숫자 더하기
	public static void main(String[] args) {
		int[] numlist= {1,2,3,4,5,6}; 
		int n=4;
		Solution43 s=new Solution43();
		int[] result=s.solution(numlist,n);
		for(int i=0; i<result.length; i++) {
			System.out.println("특정 숫자 결과: "+result[i]);
		}
	}
}
class Solution43 {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        answer = new int[numlist.length];
        double[] order = new double[numlist.length];
        
        for(int i=0; i<numlist.length; i++) {
            if(numlist[i]-n<0) {
                order[i] = ((int)Math.abs(numlist[i]-n))+0.5;
            } else {
                order[i] = numlist[i]-n;
            }
        }
        
        // 정렬
        for(int i=0; i<order.length; i++) {
            for(int j=0; j<order.length-1-i; j++) {
                if(order[j]>order[j+1]) {                   
                    double tmp = order[j];
                    order[j] = order[j+1];
                    order[j+1] = tmp;                  
                }              
            }
        }
        
        for(int i=0; i<numlist.length; i++) {
            if(order[i]%1!=0) {
                answer[i] = n-(int)order[i];
            } else {
                answer[i] = (int)order[i]+n;
            }
        }
        
        return answer;
    }
}
