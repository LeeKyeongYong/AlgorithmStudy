package com.javabook.progmers02;

public class Sample032 {//케릭터의좌표
	public static void main(String[] args) {
		String[] keyinput= {"left", "right", "up", "right", "right"};
		int[] board= {11,11};
		
		Solution32 s=new Solution32();
		int[] result=s.solution(keyinput, board);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+",");
		}
	}
}
class Solution32 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        answer = new int[2];
        for(String s: keyinput) {
        	switch(s) {
        	case "up": 
        		if(answer[1]>=board[1]/2) {
        			continue;
        		  }
        		 answer[1]+=1;
             break;
        	case "down": 
        		if(answer[1]<=-(board[1]/2)) {
        			continue;
        		  }
        			answer[1]-=1;  
        	break;		
        	case "right": 
        		if(answer[0]>=board[0]/2) {
        			continue;
        		  }
        			answer[0]+=1; 
        	break;		
        	 default :
        		 if(answer[0]<= -(board[0]/2)) {
        			 continue;
        		 }
        		 answer[0]-=1;
        	  break;   
        	}
        }
        return answer;
    }
}