package com.algorithm2023.jababookbacojoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example20241006_lcs {
    static class BitSet {
        private long[] bits;
        private final int size;

        public BitSet(int size) {
            this.size = size;
            this.bits = new long[(size + 63) / 64];
        }

        public void set(int pos) {
            if (pos >= 0 && pos < size) {
                bits[pos / 64] |= 1L << (pos % 64);
            }
        }

        public boolean get(int pos) {
            if (pos >= 0 && pos < size) {
                return (bits[pos / 64] & (1L << (pos % 64))) != 0;
            }
            return false;
        }

        public void shiftLeft() {
            for (int i = bits.length - 1; i > 0; i--) {
                bits[i] = (bits[i] << 1) | (bits[i - 1] >>> 63);
            }
            bits[0] <<= 1;
        }

        public BitSet or(BitSet other) {
            BitSet result = new BitSet(size);
            for (int i = 0; i < bits.length; i++) {
                result.bits[i] = this.bits[i] | other.bits[i];
            }
            return result;
        }

        public BitSet subtract(BitSet other) {
            BitSet result = new BitSet(size);
            long borrow = 0;
            for (int i = 0; i < bits.length; i++) {
                long diff = this.bits[i] - other.bits[i] - borrow;
                borrow = ((~this.bits[i] & other.bits[i]) | ((~this.bits[i] | other.bits[i]) & diff)) >>> 63;
                result.bits[i] = diff;
            }
            return result;
        }

        public BitSet and(BitSet other) {
            BitSet result = new BitSet(size);
            for (int i = 0; i < bits.length; i++) {
                result.bits[i] = this.bits[i] & other.bits[i];
            }
            return result;
        }

        public BitSet xor(BitSet other) {
            BitSet result = new BitSet(size);
            for (int i = 0; i < bits.length; i++) {
                result.bits[i] = this.bits[i] ^ other.bits[i];
            }
            return result;
        }

        public int countOnes() {
            int count = 0;
            for (long bit : bits) {
                count += Long.bitCount(bit);
            }
            return count;
        }
    }

    public static int LCS(String a, String b, int maxSize) {
        BitSet D = new BitSet(maxSize);
        BitSet[] S = new BitSet[26];

        for (int i = 0; i < 26; i++) {
            S[i] = new BitSet(maxSize);
        }

        // 문자열 b의 각 위치에 대해 비트셋 설정
        for (int i = 0; i < b.length(); i++) {
            S[b.charAt(i) - 'A'].set(i);
        }

        // LCS 계산
        for (int i = 0; i < a.length(); i++) {
            BitSet x = S[a.charAt(i) - 'A'].or(D);
            D.shiftLeft();
            D.set(0);
            D = x.and(x.xor(x.subtract(D)));
        }

        return D.countOnes();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        System.out.println(LCS(a, b, 50000));
    }
}
