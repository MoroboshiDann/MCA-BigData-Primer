package org.moroboshidan;

public class RadixSort {
    final static int radix = 10;
    public void radixSort(int[] arr, int left, int right) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max < arr[i] ? arr[i] : max;
        }
        int digit = 0;
        while (max > 0) {
            max = max / radix;
            ++digit;
        }
        ++digit;
        sort(arr, 0, arr.length - 1, digit);
    }

    private void sort(int[] arr, int left, int right, int digit) {
        int[] count = new int[radix];
        int[] help = new int[arr.length];
        for (int d = 0; d < digit; d++) {
            int r = radix << d;
            for (int i = left; i <= right; i++) {
                count[arr[i] % r]++;
            }
            int sum = 0;
            for (int i = 0; i < radix; i++) {
                sum += count[i];
                count[i] = sum;
            }
            for (int i = right; i >= left; i--) {
                help[count[arr[i] % r]] = arr[i];
                count[arr[i] % r]--;
            }
            for (int i = left; i <= right; i++) {
                arr[i] = help[i];
            }
        }
    }
}
