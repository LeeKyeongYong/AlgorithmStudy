package com.javabook.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240428_04 {
    private int serverIndex;
    private Map<Integer, Integer> stickyMap;

    public int[][] solution(int servers, boolean sticky, int[] requests) {
        stickyMap = new HashMap<>();
        List[] server = new List[servers];
        for (int index = 0; index < servers; index++) {
            server[index] = new ArrayList<Integer>();
        }

        serverIndex = 0;
        for (int request : requests) {
            if (sticky) {
                server[getStickyServerIndex(request, servers)].add(request);
                continue;
            }
            server[serverIndex].add(request);
            increaseServerIndex(servers);
        }
        return convertTo2DArray(server);
    }

    private int getStickyServerIndex(int request, int servers) {
        if (stickyMap.containsKey(request)) {
            return stickyMap.get(request);
        }
        stickyMap.put(request, serverIndex);
        int currentIndex = serverIndex;
        increaseServerIndex(servers);
        return currentIndex;
    }

    private void increaseServerIndex(final int servers) {
        serverIndex = (serverIndex + 1) % servers;
    }

    public int[][] convertTo2DArray(List[] listArray) {
        int[][] result = new int[listArray.length][];

        for (int i = 0; i < listArray.length; i++) {
            List<Integer> list = listArray[i];
            result[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                result[i][j] = list.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
