package com.javabook.progmers0;

public class Sample039 {
	public static void main(String[] args) {
		Solution39 s=new Solution39();
		int[] emergency={1,2,3,4,5,6,7};
		int [] solution=s.solution(emergency);
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution39 {
    public int[] solution(int[] emergency) {
        int[] answer = {};
        answer=new int[emergency.length];
        int []resultArr=emergency.clone();
        
      //오름차순
        for(int i=0;i<resultArr.length-1;i++){
            
            for(int j=0; j<resultArr.length-1-i;j++){
                if(resultArr[j]>resultArr[j+1]){                   
                    int tmp = resultArr[j];
                    resultArr[j] = resultArr[j+1];
                    resultArr[j+1] = tmp;                  
                }              
            }          
        }
        
        
        for(int i=0; i<emergency.length; i++) {
        	for(int j=0; j<resultArr.length; j++) {
	        	if(emergency[i]==resultArr[j]) {
	        		answer[i]=emergency.length-j;
	        	}
        	}
        }
        return answer;
    }
}