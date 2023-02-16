package com.javabook.progmers02;

public class Sample021 {//�� ���� ������ ����
	public static void main(String[] args) {
		Solution021 s=new Solution021();
		String result=s.solution("abcbcdc");
		System.out.println("�� ���� ������ ����: "+result);
	}
}

class Solution021 {
    public String solution(String s) {
        String answer = "";
        int[] strArr=new int[26];
        for(int i=0; i<strArr.length; i++) { //0���� ä���ش�.
        	strArr[i]=0;
        }
        
        for(int i=0; i<s.length(); i++) {//�ݺ��� ���� ���� ���ڸ� �迭�� �����Ѵ�.
        	strArr[s.charAt(i)-97]+=1;
        }
        
        for(int i=0; i<26; i++) {
        	if(strArr[i]==1) { //�ѹ��� ������ ���ڸ� ī�����ؼ� ������ �����ϸ� ��ȯ
        		answer+=(char)(i+97);
        	}
        }
        
        return answer;
    }
}