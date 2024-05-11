package org.moroboshidan;

import java.util.HashMap;
import java.util.Map;

public class NumberOfStickers {
    public int numberOfStickers(String str, String[] arr) {
        int ans = process(str, arr);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int process(String str, String[] arr) {
        if (str.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String s : arr) {
            String rest = minus(str, s);
            if (!rest.equals(str)) {
                min = Math.min(min, process(rest, arr));
            }
        }
        return min == Integer.MAX_VALUE ? min : (min + 1);
    }

    private String minus(String str, String cur) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            ++count[str.charAt(i) - 'a'];
            --count[cur.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            while (count[i] > 0) {
                sb.append((char) (count[i] + 'a'));
                --count[i];
            }
        }
        return sb.toString();
    }

    public int numberOfStickersII(String str, String[] arr)  {
        int length = arr.length;
        int[][] stickers = new int[length][26];
        for (int i = 0; i < length; ++i) {
            int len = arr[i].length();
            for (int j = 0; j < len; ++j) {
                ++stickers[i][arr[i].charAt(j) - '0'];
            }
        }
        int ans = processII(str, stickers);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int processII(String target, int[][] stickers) {
        if (target.isEmpty()) {
            return 0;
        }
        int length = target.length();
        int[] countTarget = new int[26];
        for (int i = 0; i < length; ++i) {
            countTarget[target.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            if (sticker[target.charAt(0) - 'a'] > 0) { // 如果贴纸包含目标字符串的第一个字符，再进行递归，否则不挑选当前贴纸
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (countTarget[i] > 0) {
                        int num = countTarget[i] - sticker[i];
                        while (num > 0) {
                            sb.append((char) (i + 'a'));
                            --num;
                        }
                    }
                }
                min = Math.min(min, processII(sb.toString(), stickers));
            }
        }
        return min == Integer.MAX_VALUE ? min : (min + 1);
    }

    public int numberOfStickersIII(String str, String[] arr)  {
        int length = arr.length;
        int[][] stickers = new int[length][26];
        for (int i = 0; i < length; ++i) {
            int len = arr[i].length();
            for (int j = 0; j < len; ++j) {
                ++stickers[i][arr[i].charAt(j) - '0'];
            }
        }
        Map<String, Integer> cache = new HashMap<>();
        int ans = processIII(str, stickers, cache);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int processIII(String target, int[][] stickers, Map<String, Integer> cache) {
        if (target.isEmpty()) {
            return 0;
        }
        if (cache.containsKey(target)) return cache.get(target);
        int length = target.length();
        int[] countTarget = new int[26];
        for (int i = 0; i < length; ++i) {
            countTarget[target.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            if (sticker[target.charAt(0) - 'a'] > 0) { // 如果贴纸包含目标字符串的第一个字符，再进行递归，否则不挑选当前贴纸
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (countTarget[i] > 0) {
                        int num = countTarget[i] - sticker[i];
                        while (num > 0) {
                            sb.append((char) (i + 'a'));
                            --num;
                        }
                    }
                }
                min = Math.min(min, processII(sb.toString(), stickers));
            }
        }
        cache.put(target, min == Integer.MAX_VALUE ? min : (min + 1));
        return cache.get(target);
    }

    public static void main(String[] args) {
        NumberOfStickers numberOfStickers = new NumberOfStickers();
        String str = "babac";
        String[] arr = new String[]{"ba", "c", "abcd"};
        System.out.println(numberOfStickers.numberOfStickers(str, arr));
    }
}
