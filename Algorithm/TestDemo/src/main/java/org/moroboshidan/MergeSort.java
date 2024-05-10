package test;

public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // 先申请额外空间，用来存储有序结果
        int[] sorted = new int[right - left + 1];
        // 开始比较，将较小的元素放入有序结果数组中
        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                sorted[index++] = arr[l++];
            } else {
                sorted[index++] = arr[r++];
            }
        }
        while (l <= mid) {
            sorted[index++] = arr[l++];
        }
        while (r <= right) {
            sorted[index++] = arr[r++];
        }
        // 然后将结果复制到原数组中
        for (int i = 0; i < sorted.length; ++i) {
            arr[left + i] = sorted[i];
        }
    }

    public void mergeSortUnRecurrent(int[] arr) {
        int size = 1;
        int length = arr.length;
        while (size < length) {
            int left = 0;
            while (left < length) {
                int mid = left + size - 1;
                if (mid > length) {
                    break;
                }
                int right = Math.min(left + size, length - 1);
                merge(arr, left, mid, right);
                left = right + 1;
            }
            size <<= 1;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        new MergeSort().mergeSort(arr, 0, 8);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
