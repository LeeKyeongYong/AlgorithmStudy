package com.javabook.progmers02;
import java.util.*;
public class Sample046 { //미로탈출
	public static void main(String[] args) {
		String[] maps= {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
		Solution46 s= new Solution46();
		int result=s.solution(maps);
		System.out.println("미로탈출 결과: "+result);
	}
}
class Solution46 {
    public int solution(String[] maps) {
    	 int answer = 0;
    	 int row,col;
    	 row=maps.length;
    	 col=maps[0].length();
    	 boolean[][]checkL=new boolean[row][col];
    	 boolean[][]checkE=new boolean[row][col];
    	 int[][] disL=new int[row][col];
    	 int[][] disE=new int[row][col];
    	 Queue<RC> que=new LinkedList<>();
    	 
    	 int[] dr= {0,1,0,-1};
    	 int[] dc= {1,0,-1,0};
    	 
    	 int rL=0;
    	 int cL=0;
    	 int rE=0;
    	 int cE=0;
    	 
    	 for(int i=0; i<row; i++) {
    		 for(int j=0; j<col; j++) {
    			 if(maps[i].charAt(j)=='S') {
    				 que.add(new RC(i,j));
    				 checkL[i][j]=true;
    			 }
    		 }
    	 }
    	 boolean flug=false;
    	 
    	 
    	 //출구찾기
    	 
    	return answer;
    }
}
class RC{
	int r;
	int c;
	
	public RC(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	@Override
	public String toString() {
		return "RC [r=" + r + ", c=" + c + "]";
	}
	
}