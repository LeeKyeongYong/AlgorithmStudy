package com.javabook.progmers02;

public class Sample000 {
	public static void main(String[] args) {
		//01. 알고리즘 정의 및 합계 알고리즘 기본 짝수 2의 배수의 합.
				//Scanner sc=new Scanner(System.in);
				System.out.println("몇명의 성적을 입력해하는지 입력하세요..");
				int  num=5;
				//int num=sc.nextInt();
				int [] score=new int[num];

				int sum=0;
				int totalSum=0;

				score[0]=30;
				score[1]=50;
				score[2]=80;
				score[3]=85;
				score[4]=88;

				//for(int i=0; i<score.length; i++) {
				//	score[i]=sc.nextInt();
				//}

				for(int j=0; j<score.length; j++) {
					totalSum+=score[j];
					if(score[j]>80) {
					  sum+=score[j];
					}
				}
				//sc.close();
				System.out.println(num+" 명의 80이상의 점수: "+sum);
				System.out.println(num+" 명의 총: "+totalSum);
	}
}
