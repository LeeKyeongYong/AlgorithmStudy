package com.algorithm2023.javabook.progmers0;

public class Sample012 {
	public static void main(String[] args) {
		Solution12 s=new Solution12();
		int arrays[]= {1,2,7,19,11};
		int solution=s.solution(arrays);
		System.out.println("�迭�����: "+solution);
	}
}
class Solution12 {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int X=0;X<array.length-1;X++){
            for(int Y=X+1;Y<array.length;Y++){ //�������� ����
                if(array[X] < array[Y]){
                    int C = array[X];
                    array[X] = array[Y];
                    array[Y] = C; 
                    //System.out.println( array[X]);
                    
                    //System.out.println( array[Y]);
                }//if

               
            }//for
        }//for
        answer=array[array.length/2];
        return answer;
    }
}

