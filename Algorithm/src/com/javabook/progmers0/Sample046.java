package com.javabook.progmers0;

public class Sample046 {//구슬을 나누는 경우의 수
	public static void main(String[] args) {
		Solution46 s=new Solution46();
		int result=s.solution(5,3);
		System.out.println("구술을 나누는 경우의 수: "+result);
	}
}

class Solution46 {
    public int solution(int balls, int share) {
        int answer = 0;
        answer=combin(balls,share);
        return answer;
    }
    public int combin(int i,int j) {
    	int result=0;
    	if(j==0||i==j) {
    		result=1;
        } else {
        	result=combin(i-1, j-1)+combin(i-1,j);
        }
    	return result;
    }
    
}