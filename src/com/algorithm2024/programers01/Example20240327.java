package com.algorithm2024.programers01;

import java.util.function.Predicate;

public class Example20240327 { //2023 KAKAO BLIND RECRUITMENT 미로 탈출 명령어

    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private static final String[] term = {"d", "l", "r", "u"};
    private static int mapX, mapY;
    private static int endX, endY;
    private String tempAnswer = "";

    private final Predicate<Integer> isValidIndex = i -> i >= 0 && i < mapX;

    public boolean dfs(int x, int y, int k, String str, int diff) {
        if (k == 0 && diff == 0) {
            tempAnswer = str;
            return true;
        }
        Predicate<Integer> isDiffValid = i -> i <= k; // isDiffValid을 dfs 내부에서 정의
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValidIndex.test(nextX) && isValidIndex.test(nextY) && isDiffValid.test(diff)) {
                if ((diff % 2 == 0 && k % 2 == 0) || (diff % 2 == 1 && k % 2 == 1)) {
                    if (dfs(nextX, nextY, k - 1, str + term[i], Math.abs(nextX - endX) + Math.abs(nextY - endY))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String solution(int mapSizeX, int mapSizeY, int startX, int startY, int endX, int endY, int maxMoves) {
        mapX = mapSizeX;
        mapY = mapSizeY;
        Example20240327.endX = endX - 1;
        Example20240327.endY = endY - 1;
        int diff = Math.abs((endX - 1) - (startX - 1)) + Math.abs((endY - 1) - (startY - 1));
        dfs(startX - 1, startY - 1, maxMoves, "", diff);
        return tempAnswer.isEmpty() ? "impossible" : tempAnswer;
    }

}
