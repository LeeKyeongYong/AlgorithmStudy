package com.algorithm2024.letcode6;

import java.util.*;

public class Example20241031_q1233 {

    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');

                if (pos == -1) {
                    break;
                }

                prefix = prefix.substring(0, pos);

                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                result.add(f);
            }
        }

        return result;
    }

}
