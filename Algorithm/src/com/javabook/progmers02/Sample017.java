package com.javabook.progmers02;

public class Sample017 {
	public static void main(String[] args) {//A�� B �����
		Solution17 s=new Solution17();
		String before="olleh";
		String after="hello";
		System.out.println("A�� B �����: "+s.solution(before,after));
	}
}
class Solution17 {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] b_One=before.toCharArray();
        char[] a_One=after.toCharArray();
        
        //b_One����
        ArraySort(b_One);
        //a_One ����
        ArraySort(a_One);
        
        String beChange=new String(b_One);
        String afChange=new String(a_One);
        if(beChange.equals(afChange)){
            answer=1;
        } else {
            answer=0;
        }
        
        //answer=beChange.equals(afChange) ? 1 : 0; //�ڸ�ǰ.. ���׿����ڵ� �־��~ ������ ��
        
        return answer;
    }
    public void ArraySort(char[] sort){
        //�������� �����ϱ�
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