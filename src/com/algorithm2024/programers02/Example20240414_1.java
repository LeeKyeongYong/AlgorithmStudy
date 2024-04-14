package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240414_1 {//파일명 정렬
    static class File implements Comparable<File> {
        String file;
        String head;
        int number;
        String tail = "";

        public File(final String str) {
            this.file = str;

            boolean isFirst = false;
            int numberIndex = 0;
            int numberEndIndex = str.length();
            for (int i = 0; i < str.length(); i++) {
                if (!isFirst && Character.isDigit(str.charAt(i))) {
                    numberIndex = i;
                    isFirst = true;
                    continue;
                }

                if (isFirst && !Character.isDigit(str.charAt(i))) {
                    numberEndIndex = i;
                    break;
                }
            }

            this.head = str.substring(0, numberIndex);

            if (Math.abs(numberIndex - numberEndIndex) >= 6) {
                while (Math.abs(numberIndex - numberEndIndex) > 5) {
                    numberEndIndex--;
                }
            }

            this.number = Integer.parseInt(str.substring(numberIndex, numberEndIndex));

            if (numberEndIndex != str.length()) {
                this.tail = str.substring(numberEndIndex + 1);
            }
        }

        @Override
        public String toString() {
            return "File{" +
                    "file='" + file + '\'' +
                    ", head='" + head + '\'' +
                    ", number=" + number +
                    ", tail='" + tail + '\'' +
                    '}';
        }

        @Override
        public int compareTo(final File o) {
            String f1 = this.head.toLowerCase();
            String f2 = o.head.toLowerCase();

            if (f1.equals(f2)) {
                return this.number - o.number;
            } else if (this.number == o.number) {
                return 0;
            }

            return f1.compareTo(f2);
        }
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<File> list = new ArrayList<>();
        for (String file : files) {
            File f = new File(file);
            list.add(f);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).file;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] files = {"img123456.p321ng", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
        // 출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
    }
}
