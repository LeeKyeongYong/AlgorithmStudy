package com.algorithm2025.backjoon2.day003;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example20250304_Q389481 { // 코딩테스트 연습 2025 프로그래머스 코드챌린지 2차 예선 봉인된 주문

    private Set<String> bannedSet;
    private long[] countByLength; // 각 길이별 문자열 개수 (26^len)

    public String solution(long n, String[] bans) {
        // 삭제된 문자열을 해시셋에 저장
        bannedSet = new HashSet<>();
        for (String ban : bans) {
            bannedSet.add(ban);
        }

        // 각 길이별 문자열 개수 미리 계산 (길이 1~11)
        countByLength = new long[12]; // countByLength[0]은 사용하지 않음
        countByLength[1] = 26;
        for (int len = 2; len <= 11; len++) {
            countByLength[len] = countByLength[len - 1] * 26;
        }

        // n번째 문자열 찾기
        return findNthString(n);
    }

    private String findNthString(long n) {
        // 남은 n을 기준으로 문자열을 생성
        long remaining = n;
        StringBuilder result = new StringBuilder();

        // 길이 1부터 11까지 탐색
        for (int len = 1; len <= 11; len++) {
            // 현재 길이에서 가능한 문자열 개수
            long totalCount = countByLength[len];
            // 현재 길이에서 삭제된 문자열 개수 계산
            long bannedCount = 0;
            for (String ban : bannedSet) {
                if (ban.length() == len) {
                    bannedCount++;
                }
            }
            long validCount = totalCount - bannedCount;

            // 현재 길이에서 유효한 문자열 개수가 남은 n보다 크거나 같으면
            if (validCount >= remaining) {
                // 현재 길이에서 remaining 번째 문자열을 찾아야 함
                return findStringAtLength(len, remaining);
            } else {
                // 현재 길이를 건너뛰고 remaining 줄이기
                remaining -= validCount;
            }
        }

        // 여기까지 오지 않아야 함 (n이 범위 내에 있음이 보장됨)
        return "";
    }

    // 길이 len에서 remaining 번째 문자열 찾기
    private String findStringAtLength(int len, long remaining) {
        StringBuilder result = new StringBuilder();
        return dfsBuildString(len, remaining, result);
    }

    // DFS 방식으로 사전순으로 문자열을 생성하며 remaining 번째 문자열 찾기
    private String dfsBuildString(int len, long remaining, StringBuilder current) {
        // 길이가 목표 길이에 도달하면
        if (current.length() == len) {
            // 삭제된 문자열이면 사용할 수 없음
            if (bannedSet.contains(current.toString())) {
                return null;
            }
            // remaining이 1이면 이 문자열이 답
            if (remaining == 1) {
                return current.toString();
            }
            return null;
        }

        long currentRemaining = remaining;
        // 현재 위치에서 가능한 문자(a-z) 탐색
        for (char c = 'a'; c <= 'z'; c++) {
            current.append(c);
            // 지금까지 만든 접두사로 시작하는 문자열 개수 계산
            long count = countStringsWithPrefix(current.toString(), len);
            // 삭제된 문자열 제외
            long bannedCount = 0;
            for (String ban : bannedSet) {
                if (ban.length() == len && ban.startsWith(current.toString())) {
                    bannedCount++;
                }
            }
            long validCount = count - bannedCount;

            if (validCount >= currentRemaining) {
                // 현재 접두사로 진행 가능
                String result = dfsBuildString(len, currentRemaining, current);
                if (result != null) {
                    return result;
                }
            }
            // validCount만큼 건너뛰기
            currentRemaining -= validCount;
            if (currentRemaining <= 0) {
                break;
            }
            current.setLength(current.length() - 1);
        }

        return null;
    }

    // 주어진 접두사로 시작하는 길이 len인 문자열 개수 계산
    private long countStringsWithPrefix(String prefix, int len) {
        int remainingLength = len - prefix.length();
        if (remainingLength <= 0) {
            return 1;
        }
        return countByLength[remainingLength];
    }
}
