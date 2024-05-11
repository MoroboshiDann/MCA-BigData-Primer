package org.moroboshidan;

public class MoveTheHorse {
    public int method(int x, int y, int step) {
        if (x < 0 || y < 0) return 0;
        return process(0, 0, x, y, step);
    }

    private int process(int i, int j, int x, int y, int rest) {
        if (i < 0 || j < 0 || x > 9 || y > 8) return 0;
        if (rest == 0) {
            return i == x && j == y ? 1 : 0;
        }
        int ans = 0;
        // 可以往八个方向走
        ans += process(i + 2, j + 1, x, y, rest - 1);
        ans += process(i + 1, j + 2, x, y, rest - 1);
        ans += process(i - 1, j + 2, x, y, rest - 1);
        ans += process(i - 2, j + 1, x, y, rest - 1);
        ans += process(i - 2, j - 1, x, y, rest - 1);
        ans += process(i - 1, j - 2, x, y, rest - 1);
        ans += process(i + 1, j - 2, x, y, rest - 1);
        ans += process(i + 2, j - 1, x, y, rest - 1);
        return ans;
    }


}
