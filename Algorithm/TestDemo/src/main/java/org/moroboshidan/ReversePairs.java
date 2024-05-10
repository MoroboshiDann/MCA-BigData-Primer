package test;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(nums, left, mid) +
            mergeSort(nums, mid + 1, right) +
            merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int window = mid + 1;
        for (int i = left; i <= mid; ++i) {
            while (window <= right && nums[i] > (nums[window] << 1)) ++window;
            count += (window - mid - 1);
        }
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                temp[index] = nums[l++];
            } else {
                temp[index] = nums[r++];
            }
            ++index;
        }
        while (l <= mid) {
            temp[index++] = nums[l++];
        }
        while (r <= right) {
            temp[index++] = nums[r++];
        }
        for (int i = 0; i < index; ++i)  {
            nums[left + i] = temp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 2, 3, 1};
        System.out.println(new ReversePairs().reversePairs(nums));
    }
}
