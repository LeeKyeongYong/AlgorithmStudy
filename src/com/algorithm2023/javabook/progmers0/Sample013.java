package com.algorithm2023.javabook.progmers0;

public class Sample013 {
	public static void main(String[] args) {
		System.out.println("�ּҺ� �� ���ϱ�: ");
		Solution13 s=new Solution13();
		//int[] array= {1,2,3,3,4}; //����� 3
		//int[] array= {1,1,2,2}; //����� -1
		int[] array= {1};
		System.out.println(s.solution(array));
	}
}
class Solution13 {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] bin=new int[1001];
        
        int max=0;
        
        int m_idx=0;
        
        int cnt=0;

    	if(array.length>0&&array.length<1000) { 
    		
	        for(int i=0; i<array.length; i++) {
	        	bin[array[i]]++;
	        }
	        
	        for(int i=0; i<bin.length; i++) {
	        	if(bin[i]>max) {
	        		max=bin[i];
	            	m_idx=i;
	        	}
	        }
	        
	        for(int i=0; i<bin.length; i++) {
	        	if(bin[i]==max)
	        		cnt++;
	        }
	        
	        if(cnt>1) {
	        	answer=-1;
	        } else {
	        	answer=m_idx;
	        }
    	}
        return answer;
    }
}