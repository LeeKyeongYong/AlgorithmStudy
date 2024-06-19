package com.algorithm2024.letcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240619_q826 {

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();

        for (String s : sentence.split(" ")) {
            boolean add = false;
            int length = Integer.MAX_VALUE;
            String toInsert = "";

            for (String d : dictionary) {
                if (s.startsWith(d) && d.length() <= length) {
                    toInsert = d;
                    length = d.length();
                    add = true;
                }
            }

            if (!add) {
                sb.append(s + " ");
            } else {
                sb.append(toInsert + " ");
            }
        }

        if (sb.length() >= 2) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

}
