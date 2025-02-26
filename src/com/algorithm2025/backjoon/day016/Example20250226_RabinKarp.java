package com.algorithm2025.backjoon.day016;

public class Example20250226_RabinKarp {
    // 소수 (롤링 해시에 사용)
    private static final int PRIME = 101;

    public static void search(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        // 패턴과 검색 대상 텍스트의 첫 윈도우의 해시값을 계산할 진수
        int base = 1;

        // 해시 값
        int patternHash = 0;
        int textHash = 0;

        // 패턴 길이에 기반한 진수(거듭제곱) 계산
        for (int i = 0; i < patternLength - 1; i++) {
            base = (base * 256) % PRIME;
        }

        // 패턴과 텍스트의 첫 윈도우의 해시값 계산
        for (int i = 0; i < patternLength; i++) {
            patternHash = (256 * patternHash + pattern.charAt(i)) % PRIME;
            textHash = (256 * textHash + text.charAt(i)) % PRIME;
        }

        // 패턴 검색 시작
        for (int i = 0; i <= textLength - patternLength; i++) {
            // 해시값이 일치할 경우 문자 단위로 비교
            if (patternHash == textHash) {
                boolean found = true;

                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    System.out.println("패턴이 인덱스 " + i + "에서 발견됨");
                }
            }

            // 다음 윈도우의 해시값 계산 (롤링 해시)
            if (i < textLength - patternLength) {
                textHash = (256 * (textHash - text.charAt(i) * base) + text.charAt(i + patternLength)) % PRIME;

                // 음수 해시값 처리
                if (textHash < 0) {
                    textHash += PRIME;
                }
            }
        }
    }

    // 테스트 예제
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.out.println("텍스트: " + text);
        System.out.println("패턴: " + pattern);
        search(text, pattern);
    }
}
