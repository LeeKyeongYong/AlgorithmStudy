package com.javabook.progmers02;

public class Sample019 {//������
	public static void main(String[] args) {
		Solution19 s=new Solution19();
		//int []array= {3,10,28};
		//int n=20;
		int []array= {10,11,12};
		int n=13;
		int result=s.solution(array, n);
		System.out.println("������: "+result);
	}
}
class Solution19 {
    public int solution(int[] array, int n) {
    	
        int answer = 0;
        
        //����������������  ���ĵ� ���ڸ� ���Ѵ�.
        for(int i=0;i<array.length-1;i++){
            
            for(int j=0; j<array.length-1-i;j++){
                if(array[j]>array[j+1]){                   
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;                  
                }              
            }          
        }
        
        for(int i=0; i<array.length; i++) {
        	if(array[i]>=n) {
        		int num1=n-array[i-1];
        		int num2=array[i]-n;
        		
        		if(num1>num2) {
        			answer=array[i];
        			return answer;
        		} else if(num1<num2) {
        			answer=array[i-1];
        			return answer;
        		}  else if(num1==num2) {
        			answer=array[i-1];
        			return answer;
        		} 
        	}
        }
        
        answer=array[array.length-1];
        return answer;
    }
}