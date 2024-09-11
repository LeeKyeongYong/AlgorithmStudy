package com.javabook.algoritm1;

import java.util.Arrays;

public class Example20240911_StableSelectionSort_2 { //안전정인 버전의 선택정렬 2

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j= i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]){
        int[] arr={4,5,3,2,4,1};
        System.out.println("원본 배열: "+ Arrays.toString(arr));
        selectionSort(arr);

        System.out.println("정렬된 배열: ");
        for(int value: arr){
            System.out.print(value+" ");
        }
    }

}
