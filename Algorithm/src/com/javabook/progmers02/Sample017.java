package com.javabook.progmers02;

public class Sample017 {
	public static void main(String[] args) {//A로 B 만들기
		Solution17 s=new Solution17();
		String before="olleh";
		String after="hello";
		System.out.println("A로 B 만들기: "+s.solution(before,after));
	}
}
class Solution17 {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] b_One=before.toCharArray();
        char[] a_One=after.toCharArray();
        
        //b_One정렬
        ArraySort(b_One);
        //a_One 정렬
        ArraySort(a_One);
        
        String beChange=new String(b_One);
        String afChange=new String(a_One);
        if(beChange.equals(afChange)){
            answer=1;
        } else {
            answer=0;
        }
        
        //answer=beChange.equals(afChange) ? 1 : 0; //자매품.. 삼항연산자도 있어요~ ㅎㅎㅎ ㅋ
        
        return answer;
    }
    public void ArraySort(char[] sort){
        //오름차순 정렬하기
        for(int i=0;i<sort.length-1;i++){
            
            for(int j=0; j<sort.length-1-i;j++){
                if(sort[j]>sort[j+1]){                   
                    char tmp = sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1] = tmp;                  
                }              
            }          
        }
    }
}