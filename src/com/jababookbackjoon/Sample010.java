package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Sample010 { //20006 백준 랭킹전 대기열
	static class Info{
		String name;
		int level;
		public Info(int level,String name) {
			super();
			this.name = name;
			this.level = level;
		}
		
	}
	static boolean compare(Info a,Info b) {
		return a.name.compareTo(b.name)<0;	
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Map<Integer,List<Info>> rooms = new HashMap<>();
		
		int p=sc.nextInt(); //각플레이수
		int m=sc.nextInt(); //각 방의 최대인원수
		
		boolean flag;
		int index=0;
		for(int i=0; i<p; i++) {
			Info player=new Info(sc.nextInt(),sc.next()); //플레이어의 레벨의정보 받음..
			flag=false;
			if(rooms.size()==0) {//아무것도 없을때
				rooms.put(index++,new ArrayList<Info>(Arrays.asList(player)));
				continue;
			}
			for(Map.Entry<Integer,List<Info>>entry:rooms.entrySet()) {
				List<Info> room=entry.getValue();
				if(room.size()>=m)
					continue;
				if(room.get(0).level-10<=player.level&&room.get(0).level+10>=player.level) {
					room.add(player);
					flag=true;
					break;
				}
			}
			if(flag)
				continue;
			
			rooms.put(index++,new ArrayList<Info>(Arrays.asList(player)));
		}
		for(Map.Entry<Integer,List<Info>> entry:rooms.entrySet()) {
			List<Info> room=entry.getValue();
			if(room.size()>=m) //최대인원이 찼을경우
				System.out.println("started!");
			else //그렇지않을경우
				System.out.println("Waiting!");
			
			Collections.sort(room,(a,b) -> compare(a,b)?-1:1); //플레이어의 이름을 알파벳순으로 정렬
			
			for(Info Player:room) {
				System.out.println(Player.level+" "+Player.name);
			}
			
		}
		sc.close();
	}
	
}
/*
입력>>
10 5
10 a
15 b
20 c
25 d
30 e
17 f
18 g
26 h
24 i
28 j
*/

//설명
/*
각 방은 List<Info>로 구현되어 있으며, 
방을 추가할 때마다 index 값을 1씩 증가시켜 새로운 방을 만들고 있습니다. 
각 방은 최대 인원 수를 가지고 있으며, 인원이 다 찼을 경우 다음 방으로 넘어가는 방식으로 동작합니다.
*/