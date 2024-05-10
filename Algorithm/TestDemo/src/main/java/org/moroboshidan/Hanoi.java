package org.moroboshidan;

public class Hanoi {
    public void hanoiI(int n) {
        leftToRight(n); // 将左边柱子上的所有圆盘都转移到右边圆盘上
    }

    public void leftToRight(int n) {
        if (n == 1) { // base case，左边柱子上只有一个圆盘，直接转移
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n - 1); // 将底部圆盘上面的所有圆盘都转移到中间
        System.out.println("Move " + n + " from left to right");
        midToRight(n - 1); // 将中间柱子上的圆盘都转移到右边
    }

    public void leftToMid(int n) {
        if (n == 1) { // base case，左边柱子上只有一个圆盘，直接转移到中间
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n - 1); // 左边柱子上有n个圆盘，需要先将所有的圆盘都转移到右边，才能将最底部的转移到中间
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n - 1); // 再将刚刚放到右边的所有圆盘都放到中间
    }

    public void midToRight(int n) {
        if (n == 1) { // base case，中间柱子上只有一个圆盘，直接转移到右边
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n - 1); // 中间柱子上有n个圆盘，需要先将所有的圆盘都转移到左边，才能将最底部的转移到右边
        System.out.println("Move " + n + " from mid to right ");
        leftToRight(n - 1); // 再将刚刚放到左边的所有圆盘都放到右边
    }

    public void midToLeft(int n) {
        if (n == 1) { // base case，中间柱子上只有一个圆盘，直接转移到左边
            System.out.println("Move 1 from mid to left");
            return;
        }
        midToRight(n - 1); // 中间柱子上有n个圆盘，需要先将所有的圆盘都转移到右边，才能将最底部的转移到左边
        System.out.println("Move " + n + " from mid to left");
        rightToLeft(n - 1); // 再将刚刚放到右边的所有圆盘都放到左边
    }

    public void rightToMid(int n) {
        if (n == 1) { // base case，右边柱子上只有一个圆盘，直接转移到中间
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1); // 右边柱子上有n个圆盘，需要先将所有的圆盘都转移到左边，才能将最底部的转移到中间
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n - 1); // 再将刚刚放到左边的所有圆盘都放到中间
    }

    public void rightToLeft(int n) {
        if (n == 1) { // base case，右边柱子上只有一个圆盘，直接转移到左边
            System.out.println("Move 1 from right to left");
            return;
        }
        rightToMid(n - 1); // 右边柱子上有n个圆盘，需要先将所有的圆盘都转移到中间，才能将最底部的转移到左边
        System.out.println("Move " + n + " from right to left");
        midToLeft(n - 1); // 再将刚刚放到中间的所有圆盘都放到左边
    }

    public void hanoiII(int n) {
        process(n, "left", "right", "mid");
    }

    private void process(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        process(n - 1, from, other, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        process(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        new Hanoi().hanoiI(3);
        System.out.println("======");
        new Hanoi().hanoiII(3);
    }
}
