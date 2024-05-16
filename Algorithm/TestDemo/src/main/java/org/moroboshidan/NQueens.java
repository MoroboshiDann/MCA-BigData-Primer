package org.moroboshidan;

public class NQueens {
    public int NQueens(int n) {
        if (n < 1) return 0;
        int col = 0, leftCorner = 0, rightCorner = 0;
        return process(0, col, leftCorner, rightCorner, n);
    }

    private int process(int index, int col, int leftCorner, int rightCorner, int n) {
        if (index == n) {
            return 1;
        }
        int positions = col | leftCorner | rightCorner;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int isAvailable = ((1 << i) - 1) ^ positions;
            if (isAvailable != 0) {
                // 更新三个标记数
                ans += process(index + 1, col | isAvailable, leftCorner | (isAvailable >> 1), rightCorner | (isAvailable << 1), n);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.NQueens(2));
    }
}
