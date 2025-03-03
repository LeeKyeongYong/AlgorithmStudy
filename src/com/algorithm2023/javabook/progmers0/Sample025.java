package com.algorithm2023.javabook.progmers0;

public class Sample025 {
	public static void main(String[] args) {
		//int sides[]= {1,2,3};
		//int sides[]= {3,6,2};
		int sides[]= {192,72,222};
		Solution25 s=new Solution25();
		int result=s.solution(sides);
		System.out.println(result);
		
		if(result==1) {
			System.out.println("�ﰢ���� �ϼ��Ҽ� �ֽ��ϴ�.");
		}else {
			
			System.out.println("�ﰢ���� �ϼ��Ҽ� �����ϴ�.");
		}
		
	}
}
class Solution25 {
    public int solution(int[] sides) {
    	
        int answer = 0;
        
    	//����������������  ���ĵ� ���ڸ� ���Ѵ�.
        for(int i=0;i<sides.length-1;i++){
            
            for(int j=0; j<sides.length-1-i;j++){
                if(sides[j]>sides[j+1]){                   
                    int tmp = sides[j];
                    sides[j] = sides[j+1];
                    sides[j+1] = tmp;                  
                }              
            }          
        }
        
        //���ĵ� �迭�� 0���� 1���� ���Ѵ�.
 
        int sum=sides[0]+sides[1];
        
        if(sum>sides[2]) {
        	answer=1;
        } else {
        	answer=2;
        }
        return answer;
    }
}