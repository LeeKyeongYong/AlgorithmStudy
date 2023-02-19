package com.javabook.progmers02;

public class Sample036 { //직사각형 넓이 구하기
	public static void main(String[] args) {
		//[[1, 1], [2, 1], [2, 2], [1, 2]]
		//[[-1, -1], [1, 1], [1, -1], [-1, 1]]
		//int[][] dots= {{1,1},{2,1},{2,2},{1,2}};
		int[][] dots= {{-1,-1},{1,1},{1,-1},{-1,1}};
		Solution36 s=new Solution36();
		int result=s.solution(dots);
		System.out.println("직사각형 넓이 구하기: "+result);
	}
}

class Solution36 {
    public int solution(int[][] dots) {
        int answer = 0;
        int w=0;
        int h=0;
        int wdis=0;
        int hdis=0;
        
        for(int i=1; i<4; i++) {
        	if((dots[0][0]!=dots[i][0])&&(dots[0][1]!=dots[i][1])) {
        		w=dots[i][0];
        		h=dots[i][1];
        		break;
        	}
        }
        
        wdis=(int)Math.sqrt((int)(Math.pow(dots[0][0]-w,2)));
        hdis=(int)Math.sqrt((int)(Math.pow(dots[0][1]-h,2)));
        
        answer=wdis*hdis;
        return answer;
    }
}