package com.algorithm2024.programers07;

import java.util.HashMap;
import java.util.Map;

public class Example20241105_q1 { //[PCCP 기출문제] 1번 / 붕대 감기

    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> attackInfo = new HashMap<>();
        int maxTime = 0;

        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
            if (attack[0] > maxTime) {
                maxTime = attack[0];
            }
        }

        int curHealth = health;
        int consecutiveSafeTurns = 0;

        for (int time = 1; time <= maxTime; time++) {
            if (attackInfo.containsKey(time)) {
                curHealth -= attackInfo.get(time);
                consecutiveSafeTurns = 0;
            } else {
                
                curHealth += bandage[1];
                consecutiveSafeTurns++;

                if (consecutiveSafeTurns == bandage[0]) {
                    curHealth += bandage[2];
                    consecutiveSafeTurns = 0;
                }


                if (curHealth > health) {
                    curHealth = health;
                }
            }


            if (curHealth <= 0) {
                return -1;
            }
        }

        return curHealth;
    }

}
