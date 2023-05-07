package com.javabook.progmers02;

public class Sample003 { //배열 회전하기
	public static void main(String[] args) {
		int[] numbers= {1,2,3};
		String direction="right";
		Solution003 s=new Solution003();
		int[] solution=s.solution(numbers, direction);
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution003 {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        answer = new int[numbers.length];
        if(direction.equals("right")){
            for(int i = 0; i < answer.length - 1; i++){
                answer[i + 1] = numbers[i];
            }
            answer[0] = numbers[numbers.length -1];
        }else {
            for(int i = 0; i < answer.length - 1; i++){
                answer[i] = numbers[i + 1];
            }
            answer[answer.length - 1] = numbers[0];
        }
        return answer;
    }
}