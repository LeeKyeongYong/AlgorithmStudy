package com.javabook.progmers02;

public class Sample033 {//�����ִ� ����
	public static void main(String[] args) {
		String my_String="aAb1B2cC34oOp";
		Solution33 s=new Solution33();
		int result=s.solution(my_String);
		System.out.println("�����ִ� ����: "+result);
	}
}
class Solution33 {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr=my_string.replaceAll("[^0-9]"," ").split(" ");
        
        for(int i=0; i<arr.length; i++) {
        
        	if(arr[i].equals("")) {
        		continue;
        	} else {
        		answer+=Integer.parseInt(arr[i].trim());
        	}
        	
        }
        
        return answer;
    }
}