package org.moroboshidan;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequenceI(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        return processI(a, b, a.length() - 1, b.length() - 1);
    }

    // 返回String a 0...i 范围上 和 String b 0...j 范围上的公共子序列的长度
    private int processI(String a, String b, int i, int j) {
        if (i == 0 && j == 0) {
            return a.charAt(0) == b.charAt(0) ? 1 : 0;
        } else if (i == 0) {
            if (a.charAt(i) == b.charAt(j)) {
                return 1;
            } else {
                return processI(a, b, i, j - 1);
            }
        } else if (j == 0) {
            if (a.charAt(i) == b.charAt(j)) {
                return 1;
            } else {
                return processI(a, b, i - 1, j);
            }
        } else {
            int p1 = processI(a, b, i - 1, j);
            int p2 = processI(a, b, i, j - 1);
            int p3 = a.charAt(i) == b.charAt(j) ? 1+  processI(a, b, i - 1, j - 1) : 0;
            return Math.max(Math.max(p1, p2), p3);
        }
    }

    public int longestCommonSubsequenceII(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int[][] cache = new int[a.length()][b.length()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return processII(a, b, a.length() - 1, b.length() - 1, cache);
    }

    private int processII(String a, String b, int i, int j, int[][] cache) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (i == 0 && j == 0) {
            cache[i][j] = a.charAt(0) == b.charAt(0) ? 1 : 0;
        } else if (i == 0) {
            if (a.charAt(i) == b.charAt(j)) {
                cache[i][j] = 1;
            } else {
                cache[i][j] = processII(a, b, i, j - 1, cache);
            }
        } else if (j == 0) {
            if (a.charAt(i) == b.charAt(j)) {
                cache[i][j] = 1;
            } else {
                cache[i][j] = processII(a, b, i - 1, j, cache);
            }
        } else {
            int p1 = processII(a, b, i - 1, j, cache);
            int p2 = processII(a, b, i, j - 1, cache);
            int p3 = a.charAt(i) == b.charAt(j) ? 1 + processII(a, b, i - 1, j - 1, cache) : 0;
            cache[i][j] = Math.max(p1, Math.max(p2, p3));
        }
        return cache[i][j];
    }

    public int longestCommonSubsequenceIII(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int lengthA = a.length();
        int lengthB = b.length();
        int[][] cache = new int[lengthA][lengthB];
        cache[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
        for (int i = 1; i < lengthA; i++) { // 填第一列
            cache[i][0] = a.charAt(i) == b.charAt(0) ? 1 : cache[i - 1][0];
        }
        for (int i = 1; i < lengthB; i++) { // 填第一行
            cache[0][i] = a.charAt(0) == b.charAt(i) ? 1 : cache[0][i - 1];
        }
        for (int i = 1; i < lengthA; i++) {
            for (int j = 1; j < lengthB; j++) {
                int p1 = cache[i - 1][j];
                int p2 = cache[i][j - 1];
                int p3 = a.charAt(i) == b.charAt(j) ? 1 + cache[i - 1][j - 1] : 0;
                cache[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return cache[lengthA - 1][lengthB - 1];
    }
}
