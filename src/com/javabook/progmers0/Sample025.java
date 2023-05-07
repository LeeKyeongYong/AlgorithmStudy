package com.javabook.progmers0;

public class Sample025 {
	public static void main(String[] args) {
		//int sides[]= {1,2,3};
		//int sides[]= {3,6,2};
		int sides[]= {192,72,222};
		Solution25 s=new Solution25();
		int result=s.solution(sides);
		System.out.println(result);
		
		if(result==1) {
			System.out.println("삼각형을 완성할수 있습니다.");
		}else {
			
			System.out.println("삼각형을 완성할수 없습니다.");
		}
		
	}
}
class Solution25 {
    public int solution(int[] sides) {
    	
        int answer = 0;
        
    	//오름차순정렬으로  정렬된 숫자를 비교한다.
        for(int i=0;i<sides.length-1;i++){
            
            for(int j=0; j<sides.length-1-i;j++){
                if(sides[j]>sides[j+1]){                   
                    int tmp = sides[j];
                    sides[j] = sides[j+1];
                    sides[j+1] = tmp;                  
                }              
            }          
        }
        
        //정렬된 배열의 0번과 1번을 더한다.
 
        int sum=sides[0]+sides[1];
        
        if(sum>sides[2]) {
        	answer=1;
        } else {
        	answer=2;
        }
        return answer;
    }
}