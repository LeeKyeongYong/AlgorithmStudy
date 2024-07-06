package com.algorithm2024.programers04;

import java.util.*;

public class Example20240706_07 { //2024 KAKAO WINTER INTERNSHIP n + 1 카드게임


    private static int n;
    private static int coinCount;
    private static Queue<Integer> player = new LinkedList<>();
    private static List<Integer> checkNum = new ArrayList<>(Collections.nCopies(1001, 0));
    private static Pair<Integer, Integer> p;

    public static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    private static boolean checkCard(int checkNumber) {
        int qSize = player.size();
        for (int i = 0; i < qSize; i++) {
            int num = player.poll();
            if (checkNum.get(num) == 0)
                continue;

            if (checkNum.get(n + 1 - num) != 0) {
                if (checkNumber == 0) {
                    if (checkNum.get(n + 1 - num) != 1 || checkNum.get(num) != 1) {
                        player.add(num);
                        continue;
                    }

                    p = new Pair<>(checkNum.get(num), checkNum.get(n + 1 - num));
                    checkNum.set(num, 0);
                    checkNum.set(n + 1 - num, 0);
                    return true;
                } else if (checkNumber == 1) {
                    if (coinCount >= 1 && ((checkNum.get(n + 1 - num) == 1 && checkNum.get(num) == 2) ||
                            (checkNum.get(n + 1 - num) == 2 && checkNum.get(num) == 1))) {
                        coinCount -= 1;
                        p = new Pair<>(checkNum.get(num), checkNum.get(n + 1 - num));
                        checkNum.set(num, 0);
                        checkNum.set(n + 1 - num, 0);
                        return true;
                    }
                } else if (checkNumber == 2) {
                    if (coinCount >= 2 && checkNum.get(n + 1 - num) == 2 && checkNum.get(num) == 2) {
                        coinCount -= 2;
                        p = new Pair<>(checkNum.get(num), checkNum.get(n + 1 - num));
                        checkNum.set(num, 0);
                        checkNum.set(n + 1 - num, 0);
                        return true;
                    }
                }
            }
            player.add(num);
        }
        return false;
    }

    public static int solution(int coin, int[] cards) {
        int answer = 0;
        n = cards.length;
        coinCount = coin;
        player.clear();
        Collections.fill(checkNum, 0);

        int index = n / 3;
        for (int i = 0; i < index; i++) {
            player.add(cards[i]);
            checkNum.set(cards[i], 1);
        }

        while (true) {
            answer++;
            if (index >= cards.length - 1)
                break;

            checkNum.set(cards[index], 2);
            checkNum.set(cards[index + 1], 2);
            player.add(cards[index]);
            player.add(cards[index + 1]);
            index += 2;

            if (checkCard(0))
                continue;

            if (coinCount > 0) {
                if (checkCard(1))
                    continue;

                if (checkCard(2))
                    continue;
            }

            break;
        }

        return answer;
    }
}
