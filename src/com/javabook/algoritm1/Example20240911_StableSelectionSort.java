package com.javabook.algoritm1;

import java.util.Arrays;

public class Example20240911_StableSelectionSort { //안전정인 버전의 선택정렬 1

    //선택정렬구현(안정적인 방식)
    public static void stableSelectionSort(int[] arr){
        int n=arr.length;

        //배열의 각 요소를 순차적으로 확인
        for(int i=0; i<n-1; i++){

            //i부터 n-1까지 최소값을 찾음
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            //최소값을 찾으면 해당 값(arr[minIndex])을
            //i 위치로 이동 (단, 같은 값을 가진 요소의 순서는 유지)
            int key = arr[minIndex];

            //최소 값을 앞으로 이동하기 위해 요소들을 한 칸 씩 뒤로 이동
            while(minIndex > i){
                arr[minIndex] = arr[minIndex - 1];
                minIndex--;
            }

            //최종적으로 최소값을 i 위치에 배치
            arr[i]=key;
        }
    }

    public static void main(String[] args){
        int[] arr={4,5,3,2,4,1};
        System.out.println("원본 배열: "+ Arrays.toString(arr));
        stableSelectionSort(arr);
        System.out.println("안정적인 선택 정렬 후: "+Arrays.toString(arr));
    }
}
