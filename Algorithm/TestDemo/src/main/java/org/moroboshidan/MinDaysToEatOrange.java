package org.moroboshidan;

import java.util.Arrays;

public class MinDaysToEatOrange {
    public int minDays(int n) {
        // 暴力递归
        return process(n);
    }

    private int process(int n) {
        if (n <= 0) {
            return 0;
        }
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        int p3 = process(n - 1);
        if (n % 2 == 0) {
            p1 = process(n / 2);
        }
        if (n % 3 == 0) {
            p2 = process(n / 3);
        }
        return Math.min(Math.min(p1, p2), p3) + 1;
    }

    public int minDaysI(int n) {
        // 动态规划
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return processI(n, cache);
    }

    private int processI(int n, int[] cache) {
        if (n <= 0) {
            return 0;
        }
        if (cache[n] == -1) {
            int p1 = Integer.MAX_VALUE;
            int p2 = Integer.MAX_VALUE;
            int p3 = processI(n - 1, cache) ;
            if (n % 2 == 0) {
                p1 = processI(n / 2, cache);
            }
            if (n % 3 == 0) {
                p2 = processI(n / 3, cache);
            }
            cache[n] = Math.min(Math.min(p1, p2), p3) + 1;
        }
        return cache[n];
    }

    public int minDaysII(int n) {
        // 动态规划
        int[] cache = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            cache[i] = cache[i - 1] + 1;
            if (i % 2 == 0) cache[i] = Math.min(cache[i / 2], cache[i]);
            if (i % 3 == 0) cache[i] = Math.min(cache[i / 3], cache[i]);
        }
        return cache[n];
    }

    public static void main(String[] args) {
        MinDaysToEatOrange obj = new MinDaysToEatOrange();
        System.out.println(obj.minDays(100));
        System.out.println(obj.minDays(9209408));
        // System.out.println(obj.minDaysI(9209408));
        System.out.println(obj.minDaysI(100));
    }
}
