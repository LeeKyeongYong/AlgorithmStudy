package com.javabook.progmers02;

import java.util.*;
public class Sample041 {//입문 로그인 성공?
	public static void main(String[] args) {
		String[] id_pw= {"meosseugi", "1234"};
		String[][] db= {{"rardss", "123"},{"yyoom", "1234"},{"meosseugi", "1234"}};
		Solution41 s=new Solution41();
		String result=s.solution(id_pw, db);
		System.out.println("입문 로그인 성공?: "+result);
	}
}
class Solution41 {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        Map<String,String> dbMap=new HashMap<String, String>();
        for(String[] strings:db) {
        	dbMap.put(strings[0],strings[1]);
        }
        if(dbMap.containsKey(id_pw[0])) {
        	if(dbMap.get(id_pw[0]).equals(id_pw[1])) {
        		answer="login";
        	} else {
        		answer="wrong pw";
            }
        } else {
        	answer="fail";
        }
        return answer;
    }
}