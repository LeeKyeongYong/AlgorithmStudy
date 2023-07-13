package com.jababookbackjoon1;

import java.util.*;

public class Sample017 { //15686 치킨배달
	
	static int N,M,Chicken_Num,Answer;
	static int [][]MAP;
	static boolean[] Select;
	static List<Pair<Integer,Integer>> House,Chicken,V;
	
	static class Pair<T,U>{ //Pair클래스를 정의한다.
		T first;
		U second;
		
	  public Pair(T first,U second) {
		  this.first=first;
		  this.second=second;
	  }
	  
	}
	
	public static void Input() {
		Scanner sc=new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		MAP = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				MAP[i][j] = sc.nextInt();
				if(MAP[i][j] == 1) House.add(new Pair<>(i,j));
				if(MAP[i][j] == 2) Chicken.add(new Pair<>(i,j));
				
			}
		}
		
		Chicken_Num = Chicken.size();
		Select = new boolean[Chicken_Num];
		sc.close();
	}
	
	static int Calculate_Distance() { //집과 치킨집 거리계산하는 함수 정의
		
		int sum=0;
		
		for(Pair<Integer,Integer> house:House) {
			
			int x = house.first;
			int y = house.second;
			int d = 99999999;
			
			for(Pair<Integer,Integer> v : V ) {
				int xx=v.first;
				int yy=v.second;
				int Dist=Math.abs(xx - x) + Math.abs(yy - y);
				
				d = Min(d,Dist);
			}
			sum += d;
		}
		
		return sum;
	}
	
	static int Min(int A,int B) { // 최솟값을 반환하는 함수 정의
		if(A<B) return A;
		return B;
	}
	
	public static void Solution() { // 해결과정 수행하는 함수 정의
		Select_Chicken(0,0);
	}
	
	static void Select_Chicken(int Idx,int cnt) { //치킨집 선택 정의
		
		if(cnt == M) {
			Answer = Min(Answer,Calculate_Distance());
			return;
		}
		
		for(int i=Idx; i<Chicken_Num; i++) {
			
			if(Select[i]) continue;
			Select[i] = true;
			V.add(Chicken.get(i));
			Select_Chicken(i, cnt+1);
			Select[i] = false;
			V.remove(V.size()-1);
		}
	}
	
	public static void main(String[] args) { //필요한 리스트 및 변수 초기화 시킨다
		
		Answer = 99999999;
		House = new ArrayList<>();
		Chicken = new ArrayList<>();
		V = new ArrayList<>();
		
		Input(); //입력을 받고 초기화
		Solution(); // 치킨집을 선택하여 거리를 계산하고 가장 짧은거리 구하는 함수
		
		System.out.println(Answer); //결과출력
		
	}
}
/*
문제>>
크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 
도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. r과 c는 1부터 시작한다.

이 도시에 사는 사람들은 치킨을 매우 좋아한다. 따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다. 
치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다.
 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.

예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.

0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 1 2
0은 빈 칸, 1은 집, 2는 치킨집이다.

(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다.
 따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.
(5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, (5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다. 
따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.
이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 
오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 최대 M개라는 사실을 알아내었다.
도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면,
 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

입력>>
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

출력>>
5
*/