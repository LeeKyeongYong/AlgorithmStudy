package com.algorithm2023.javabook.progmers0;

public class Sample031 {
	public static void main(String[] args) {
		int[] numbers= {1,2,3,4,5};
		//int[] numbers= {0,31,24,10,1,9};
		Solution31 s=new Solution31();
		int result=s.solution(numbers);
		System.out.print("������: ");
		for(int i=0; i<numbers.length; i++) {
		 System.out.print(numbers[i]+" ");
		}
		System.out.println();
		System.out.print("���ҵ��� �ִ밪: "+result);
	}
}
class Solution31 {
    public int solution(int[] numbers) {
        int answer = 0;
        
        //��������
        for(int i=0;i<numbers.length-1;i++){
            
            for(int j=0; j<numbers.length-1-i;j++){
                if(numbers[j]>numbers[j+1]){                   
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;                  
                }              
            }          
        }
        
        //���ĵ� �������� �� ���� ��
        answer=numbers[numbers.length-1]*numbers[numbers.length-2];
        return answer;
    }
}