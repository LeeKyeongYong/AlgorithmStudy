package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Sample008 { //백준 미로만들기 1347번
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); //scanner 생성
		int n=Integer.parseInt(sc.nextLine()); //로봇의 명령어 길이
		String[] arr=sc.nextLine().split(""); //로봇의명령어를 담을 문자
		int[]dx = {-1,0,1,0}; //로봇의 이동좌표
		int[]dy = {0,1,0,-1}; //로봇의 이동좌표
		
		int d=2; //로봇이 바라보는방향 초기는 2 남쪽을 바라본상태
		int x=0,y=0; //로봇이 현재 위치한 좌표 초기를 0으로 좌표잡는다.
	
		ArrayList<int[]>q=new ArrayList<int[]>();//로봇의 이동경로를 배열로 담기위해
		q.add(new int[]{0,0}); //시작점 추가한다.
		
		for(String a:arr) { //로봇의 명령어 하나씩 처리하기위해 for-each문사용
			if(a.equals("F")) { //F일경우
				x+=dx[d];
				y+=dy[d];
				q.add(new int[]{x,y});
				continue;
			}
			if(a.equals("L")) { //왼쪽으로 이동
				d--;
			} else if(a.equals("R")) { //오른쪽으로 이동
				d++;
			}
			d=(d+4)%4; // 회전후에 방향을 나타내는 값을 업데이트하기위해
		}
		
		int maxX=0,minX=99,minY=99,maxY=0;	//좌표의 최소값저장하고
		//좌표의 값을 구함..
		
		for(int[]i:q) {
			minX=Math.min(minX,i[0]);
			minY=Math.min(minY,i[1]);
		}
		
		for(int i=0; i<q.size(); i++) {
			int[]iArr=q.get(i);
			iArr[0]-=minX;
			iArr[1]-=minY;
			maxX=Math.max(maxX, iArr[0]);
			maxY=Math.max(maxY, iArr[1]);
		}

		char[][] arr2 = new char[maxX+1][maxY+1];
		for(int i=0; i<=maxX; i++) {
			for(int j=0; j<=maxY; j++) {
				arr2[i][j]='#'; //모든값에 #으로 대입...
			}
		}
		
		
		for(int[]i:q) {
			int x2 = i[0], y2 = i[1];
			arr2[x2][y2]='.'; // 로봇의 이동 경로를 표시
		}
		
	    
		
		for(char[]row:arr2) {
			System.out.println(new String(row)); //로봇의 이동 경로를 시각적으로 보여주기 위해출력
		}
		
		sc.close();
	}
}
/*
입력1>>
5
RRFRF

입력2>>
6
LFFRFF

입력3>>
14
LFLFRRFLFRRFLF

입력4>>
19
FLFRFFRFFFRFFRFLFLL

입력5>>
31
FRFFFFFFLLFRFFFFFLLFRFFFFLFFLFF
*/