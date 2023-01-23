package com.javabook.progmers0;

import java.util.Scanner;

public class Sample033 {
	public static void main(String[] args) {
		Solution33 s=new Solution33();
		Scanner sc=new Scanner(System.in);
		System.out.println("문자열을 입력해주세요..");
		String my_string=sc.next();
		int[] solution=s.solution(my_string);
		System.out.println("문자열이 아닌것은... ");
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution33 {
    public int[] solution(String my_string) {
    	
        int[] answer = {};//답안
        
        String fillter="";//정수필터링하는 문자
        
        String[] trn= {};//전환시킨다.
        
        char[] array=my_string.toCharArray(); //char로 변환
        
        for(int i=0; i<array.length; i++) {//정수추출
        	if(array[i]>=48&&array[i]<=57) { //문자열아닌것은??
        		fillter+=array[i];
        	}
        }
        
        
        answer = new int[fillter.length()];
        trn=new String[fillter.length()];
        for(int i=0; i<fillter.length(); i++) {//중복된 글자들 제거..
        	trn[i]=fillter.charAt(i)+"";
        	answer[i]=Integer.parseInt(trn[i]);
        }
        
        //오름차순 정렬하기
        for(int i=0;i<answer.length-1;i++){
            
            for(int j=0; j<answer.length-1-i;j++){
                if(answer[j]>answer[j+1]){                   
                    int tmp = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = tmp;                  
                }              
            }          
        }
        
        return answer;
    }
}