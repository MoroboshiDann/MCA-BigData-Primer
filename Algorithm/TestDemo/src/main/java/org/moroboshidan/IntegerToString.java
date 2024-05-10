package org.moroboshidan;

public class IntegerToString {
    public int possibleResult(String str) {
        return process(str, 0);
    }

    private int process(String str, int index) {
        if (str.length() == index) return 1;
        if (str.charAt(index) == '0') return 0;
        // 当前数字单独转换
        int single = process(str, index + 1);
        // 和后面的数字一起转换
        int dual = 0;
        if (index + 1 < str.length() && index + 1 < str.length() && (str.charAt(index) - '0') * 10 + (str.charAt(index + 1) - '0') < 27) {
            dual = process(str, index + 2);
        }
        return single + dual;
    }

    public int possibleResultII(String str) {
        int length = str.length();
        int[] cache = new int[length + 1];
        cache[length] = 1;
        for (int i = length - 1; i >= 0; --i) {
            if (str.charAt(i) != '0') {
                cache[i] = cache[i + 1];
                int dual = 0;
                if (i + 1 < str.length() && (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0') < 27) {
                    cache[i] += cache[i + 2];
                }
            }
        }
        return cache[0];
    }

    public static void main(String[] args) {
        IntegerToString obj = new IntegerToString();
        System.out.println(obj.possibleResult("305"));
        System.out.println(obj.possibleResultII("305"));
        System.out.println(obj.possibleResultII("111"));
    }
}
