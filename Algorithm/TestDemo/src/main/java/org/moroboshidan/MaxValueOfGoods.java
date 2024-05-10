package org.moroboshidan;

import java.util.Arrays;

public class MaxValueOfGoods {
    public int maxValueOfGoodsI(int[] weight, int[] value, int bag) {
        if (weight == null || value == null || weight.length != value.length) return 0;
        return processI(weight, value, bag, 0);
    }

    public int processI(int[] weight, int[] value, int rest, int index) {
        if (index == weight.length) { // 有可能会有商品重量为0
            return 0;
        }
        // 当前货物不装进背包和装进背包的情况下拿取的价值，取最大值
        int absent = processI(weight, value, rest, index + 1);
        int in = weight[index] <= rest ? processI(weight, value, rest - weight[index], index + 1) + value[index] : 0; // 如果当前货物重量已经不能放进背包，就不能计算价值
        return Math.max(absent, in);
    }

    public int maxValueOfGoods(int[] weight, int[] value, int bag) {
        int[][] cache = new int[weight.length][bag + 1];
        for (int i = 0; i < weight.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return processII(weight, value, 0, bag, cache);
    }

    private int processII(int[] weight, int[] value, int index, int rest, int[][] cache) {
        if (index == weight.length) {
            return 0;
        }
        if (cache[index][rest] == -1) {
            int absent = processII(weight, value, index + 1, rest, cache);
            int in = 0;
            if (weight[index] <= rest) {
                in = processII(weight, value, index + 1, rest - weight[index], cache) + value[index];
            }
            cache[index][rest] = Math.max(absent, in);
        }
        return  cache[index][rest];
    }

    public static void main(String[] args) {
        MaxValueOfGoods obj = new MaxValueOfGoods();
        int[] weight = {1, 10, 2, 5, 7};
        int[] value = {9, 100, 3, 18, 5};
        System.out.println(obj.maxValueOfGoodsI(weight, value, 9));
        System.out.println(obj.maxValueOfGoods(weight, value, 9));
    }
}
