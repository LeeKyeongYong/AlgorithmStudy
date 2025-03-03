package com.algorithm2023.jababookbackjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sample036 { //백준 16236 아기상어
	
	static final int max_int=21;
	
	static final int max_val=401;
	
	static int n;
	
	static int[][] a = new int[max_int][max_int];
	
	static int[][] check = new int[max_int][max_int];
	
	static int shark_x,shark_y,eat_cnt,shark_size=2;
	
	static int min_dist,min_x,min_y,result;
	
	static int[] dx = {0,0,1,-1};
	
	static int[] dy = {-1,1,0,0};
	
	static class Info{
		
		int x,y;
		
		Info(int x,int y){
			
			this.x=x;
			
			this.y=y;
		}
		
	}
	
	static void initCheck() {
		
		min_dist=max_val;
		
		min_x=max_int;
		
		min_y=max_int;
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=n; j++) {
				
				check[i][j]=-1;
				
			}
		}
	}
	
	static void bfs(int sx,int sy) {
		
		Queue<Info> q = new LinkedList<>();
		
		check[sx][sy] = 0;
		
		q.add(new Info(sx,sy));
		
		while(!q.isEmpty()) {
			
			Info cur = q.poll();
			
			int x = cur.x;
			
			int y = cur.y;
			
			for(int i=0; i<4; i++) {
				
				int nx = x+dx[i];
				
				int ny = y+dy[i];
				
				if(nx<1||nx > n || ny < 1 || ny > n) 
					continue;
				
				if(check[nx][ny]!=-1||a[nx][ny] > shark_size)
					continue;
				
				check[nx][ny] = check[x][y]+1;
				
				if(a[nx][ny]!=0 && a[nx][ny] < shark_size) {
					if(min_dist > check[nx][ny]) {
						
						min_x = nx;
						
						min_y = ny;
						
						min_dist = check[nx][ny];
					} else if(min_dist == check[nx][ny]) {
						if(min_x == nx) {
							if(min_y > ny) {
								min_x = nx;
								min_y = ny;
							}
						} else if(min_x > nx) {
							min_x = nx;
							min_y = ny;
						}
					}
				}
				q.add(new Info(nx,ny));
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		
		n=sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<=n; j++) {
				
				a[i][j] = sc.nextInt();
				
				if(a[i][j] == 9) {
					
					shark_x = i;
					
					shark_y = j;
					
					a[i][j]=0;
				}
				
			}
		}
		sc.close();
		
		while(true) {
			
			initCheck();
			
			bfs(shark_x,shark_y);
			
			if(min_x!=max_int && min_y != max_int) {
				
				result += check[min_x][min_y];
				
				eat_cnt++;
				
				if(eat_cnt == shark_size) {
					
					shark_size++;
					
					eat_cnt=0;
					
				}
				
				a[min_x][min_y]=0;
				
				shark_x = min_x;
				
				shark_y = min_y;
			} else {
				break;
			}
		}
		
		
		System.out.println(result);
		
	}
}
/*
입력 >> 
3
0 0 0
0 0 0
0 9 0
*/