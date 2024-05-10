package org.moroboshidan;

public class CardGameOfTwo {
    public int amountOfWinner(int[] arr) {
        return Math.max(initiative(arr, 0, arr.length - 1), gote(arr, 0, arr.length - 1));
    }

    private int initiative(int[] arr, int left, int right) { // 先手，可以自由挑选牌
        if (left == right) {
            return arr[left];
        }
        return Math.max(arr[left] + gote(arr, left + 1, right), arr[right] + gote(arr, left, right - 1));
    }

    private int gote(int[] arr, int left, int right) { // 后手，需要让对方先选
        if (left == right) {
            return 0; // 后手，且只有一张牌，所以当前轮面值为0
        }
        return Math.min(initiative(arr, left + 1, right), // 对手拿走了left位置上的牌，下面轮到自己先手选牌
                initiative(arr, left, right - 1)); // 对手拿走了right位置上的牌，轮到自己先手选牌
    }

    public static void main(String[] args) {
        int[] arr = new int[]{50, 100, 20, 10};
        CardGameOfTwo cardGameOfTwo = new CardGameOfTwo();
        System.out.println(cardGameOfTwo.amountOfWinner(arr));
    }
}
