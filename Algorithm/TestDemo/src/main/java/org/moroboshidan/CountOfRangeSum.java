package test;

public class CountOfRangeSum {
    int lower;
    int upper;
    public int countOfRangeSum(int[] arr, int lower, int upper) {
        long[] sum = new long[arr.length]; // 前缀和数组
        this.lower = lower;
        this.upper = upper;
        long temp = 0;
        int count = 0;
        for (int i = 0; i < sum.length; ++i) {
            temp += arr[i];
            sum[i] = temp;
            if (sum[i] >= lower && sum[i] <= upper) ++count;
        }
        // 通过归并排序的思路，将问题转换为小和问题
        return count + mergeSort(sum, 0, sum.length - 1);
    }

    private int mergeSort(long[] sum, int left, int right) {
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(sum, left, mid) +
            mergeSort(sum, mid + 1, right) +
            merge(sum, left, mid, right);
    }

    private int merge(long[] sum, int left, int mid, int right) {
        // 先统计数量，然后再进行归并排序
        int count = 0;
        // 直接计算，指针一直在回溯，时间复杂度还是N^2，会超时
        // for (int i = mid + 1; i <= right; ++i) {
        //     long rangeL = sum[i] - upper;
        //     long rangeR = sum[i] - lower;
        //     for (int j = left; j <= mid; ++j) {
        //         if (sum[j] >= rangeL && sum[j] <= rangeR) ++count;
        //     }
        // }
        int windowL = left;
        int windowR = left;
        for (int i = mid + 1; i <= right; ++i) {
            long rangeL = sum[i] - upper;
            long rangeR = sum[i] - lower;
            while (windowR <= mid && sum[windowR] <= rangeR) ++windowR;
            while (windowL <= mid && sum[windowL] < rangeL) ++windowL;
            count += Math.max(0, windowR - windowL); 
        }
        long[] temp = new long[right - left + 1];
        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (sum[l] < sum[r]) {
                temp[index] = sum[l];
                ++l;
            } else {
                temp[index] = sum[r];
                ++r;
            }
            ++index;
        }
        while (l <= mid) {
            temp[index] = sum[l];
            ++index;
            ++l;
        }
        while (r <= right) {
            temp[index] = sum[r];
            ++index;
            ++r;
        }
        for (int i = 0; i < index; ++i) {
            sum[left + i] = temp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2147483647,-2147483648,-1,0};
        System.out.println(new CountOfRangeSum().countOfRangeSum(arr, -2, 2));
    }
}
