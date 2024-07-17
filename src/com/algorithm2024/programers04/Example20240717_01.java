package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example20240717_01 { //2018 KAKAO BLIND RECRUITMENT [3차] 파일명 정렬
    static class FileName {
        int index;
        String head;
        int number;

        FileName(int index, String head, int number) {
            this.index = index;
            this.head = head;
            this.number = number;
        }
    }

    public static String[] solution(String[] files) {
        List<FileName> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int headEndIndex = 0;
            while (headEndIndex < file.length() && !Character.isDigit(file.charAt(headEndIndex))) {
                headEndIndex++;
            }

            String head = file.substring(0, headEndIndex).toLowerCase();
            int numberEndIndex = headEndIndex;
            while (numberEndIndex < file.length() && Character.isDigit(file.charAt(numberEndIndex))) {
                numberEndIndex++;
            }

            int number = Integer.parseInt(file.substring(headEndIndex, numberEndIndex));
            fileList.add(new FileName(i, head, number));
        }

        fileList.sort(new Comparator<FileName>() {
            @Override
            public int compare(FileName f1, FileName f2) {
                if (f1.head.equals(f2.head)) {
                    if (f1.number == f2.number) {
                        return Integer.compare(f1.index, f2.index);
                    } else {
                        return Integer.compare(f1.number, f2.number);
                    }
                } else {
                    return f1.head.compareTo(f2.head);
                }
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = files[fileList.get(i).index];
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240717_01 sol = new Example20240717_01();
        String[] p0_0 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] result = sol.solution(p0_0);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
