package org.moroboshidan;

public class NQueens {
    public int nQueens(int n) {
        if (n < 1) return 0;
        int col = 0, leftCorner = 0, rightCorner = 0;
        return process(0, col, leftCorner, rightCorner, n);
    }

    private int process(int index, int col, int leftCorner, int rightCorner, int n) {
        if (index == n) {
            return 1;
        }
        int positions = ~(col | leftCorner | rightCorner);
        int ans = 0;
        int one = 1;
        for (int i = 0; i < n; ++i) {
            int isAvailable = one & positions;
            if (isAvailable != 0) {
                // 更新三个标记数
                ans += process(index + 1, col | one, leftCorner | (one << 1),
                        rightCorner | (one >> 1), n);
            }
            one <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.nQueens(4));
    }
}
