package com.algorithm2023.javabook.progmers03;

public class Sample001 { //알고리즘 부문 문자열인지 확인하기
	public static void main(String[] args) {
		Solution001 s=new Solution001();
		String my_String="banana";
		String target="ana";
		int result = s.solutin(my_String, target);
		System.out.println("알고리즘 부문 문자열인지 확인하기: "+result);
	}
}
class Solution001{
	public int solutin(String my_string,String target) {
		int myLength = my_string.length(); //각각변수에 담아 저장한다
		int targetLength = target.length();
		
		for(int i=0; i<=myLength - targetLength; i++) { //각각담은 저장한 변수를 뺀만큼 반복을한다.
			//비교하는 문자열이 없을때까지 반복하기위해서..
			if(my_string.substring(i,i+targetLength).equals(target)) { //my_string에서 i부터 i+targetLength까지의
				//문자열을 추출한다. 추출한만큼 비교해서 일치한부분의 문자열을 찾으면
				return 1; //1을 반환한다
			}
		}
		return 0; //일치하지않으면 0을 반환한다.
	}
}
