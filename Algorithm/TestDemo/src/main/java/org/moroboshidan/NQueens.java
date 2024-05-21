package org.moroboshidan;

import java.util.Deque;
import java.util.LinkedList;

public class NQueens {
    public int nQueens(int n) {
        if (n < 1) return 0;
        int col = 0, leftCorner = 0, rightCorner = 0;
        return process(0, col, leftCorner, rightCorner, n);
    }

    private int process(int index, int col, int leftCorner, int rightCorner, int n) {
        if (index == n) { // 如果成功放置了所有的皇后，证明此种摆法有效
            return 1;
        }
        int positions = ~(col | leftCorner | rightCorner); // 取反之后，当前位上为1的，表示可以放置
        int ans = 0;
        int one = 1;
        for (int i = 0; i < n; ++i) {
            int isAvailable = one & positions; // 查看当前位是否可以放置
            if (isAvailable != 0) { // 如果可以放置，就放置
                // 更新三个标记数
                ans += process(index + 1, col | one, (leftCorner << 1) | (one << 1),
                        (rightCorner >> 1 ) | (one >> 1), n);
            }
            one <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.nQueens(4));
        System.out.println(obj.nQueens(5));
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.peekLast());
        System.out.println(queue.peekFirst());
    }
}
