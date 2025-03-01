package com.algorithm2025.backjoon.day017;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Example20250228_q4 { //10699 오늘날짜
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat smp =new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(smp.format(date));

        //기본적으로 yyyy-MM-dd 형식 출력
        System.out.println(LocalDate.now());
    }
}
