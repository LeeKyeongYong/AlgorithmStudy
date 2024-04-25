package com.algorithm2024.programers02;

import java.util.HashMap;

public class Example20240425_01 { //전화번호 Hash,String
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> map = new HashMap<>();
        for (String p : phone_book) {
            map.put(p, "");
        }

        for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if (map.containsKey(p.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solution2(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = i + 1; j < phoneBook.length; j++) {
                if (phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }

                if (phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
