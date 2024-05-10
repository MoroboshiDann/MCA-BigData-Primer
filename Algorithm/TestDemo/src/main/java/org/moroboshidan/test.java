package org.moroboshidan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class test {

    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap();
        map.put("1", new ArrayList<>());
        List<String> list = map.get("1");
        list.add("first");
        list.add("second");
        for (List<String> values : map.values()) {
            for (String value : values) {
                System.out.println(value);
            }
        }
    }

    public void selectSort(int[] nums) {
        // 遍历数组，每次找到第i小的数，放到下标为i的位置上
        for (int i = 0; i < nums.length; ++i) {
            int index = i;
            for (int j = i + 1; j < nums.length; ++j) {
                index = nums[j] < nums[index] ? j : index;
                index = j;
            }
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int index) {
        if (i != index) {
            nums[i] = nums[i] ^ nums[index];
            nums[index] = nums[i] ^ nums[index];
            nums[i] = nums[i] ^ nums[index];
        }
    }

    public void bubbleSort(int[] nums) {
        // 双重循环，每次循环将小数放到数值最前端
        for (int i = nums.length - 1; i >= 0; ++i) {
            for (int j = i; j >= nums.length - i + 1; ++j) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public void insertSort(int[] nums) {
        // 遍历数组，每个元素都和前面所有的元素比较，直到前面的元素比其小或到达边界
        for (int i = 1; i < nums.length; ++i) {
            int index = i;
            while (index > 0) {
                if (nums[index] > nums[index - 1]) {
                    break;
                }
                swap(nums, i, index);
                --index;
            }
        }
    }

    public int existLeft(int[] nums, int target) {
        // 找到有序数组中，大于等于target的最左侧位置。该数可能不存在
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int existRight(int[] nums, int target) {
        // 找到有序数组中，小于等于target的最右侧位置。该数可能不存在
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int localMin(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        // 检查边界
        if (nums[left] < nums[left + 1])
            return 0;
        if (nums[right] < nums[right - 1])
            return right;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid - 1]) {
                right = mid;
            } else if (nums[mid] > nums[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int[] findTwo(int[] nums) {
        int length = nums.length;
        int wholeEor = 0;
        for (int i = 0; i < length; ++i) {
            wholeEor ^= nums[i];
        }
        int flag = 1;
        while ((wholeEor & flag) == 0) {
            flag <<= 1;
        }
        int aEor = 0, bEor = 0;
        for (int i = 0; i < length; ++i) {
            if ((flag & nums[i]) == 0) {
                aEor ^= nums[i];
            } else {
                bEor ^= nums[i];
            }
        }
        return new int[] { aEor, bEor };
    }

    public int findK(int[] nums, int k, int m) {
        int[] bits = new int[32];
        for (int num : nums) {
            // 对于每个元素，将其看作一个32位二进制数，每一位如果为1，将bits数组对应位置元素加一
            for (int i = 0; i < 32; ++i) {
                if ((num & (1 << i)) != 0) {
                    ++bits[i];
                }
            }
        }
        int ans = 0;
        // 检查bits数组每一个元素，如果当前元素不能被m整除，表明target在这一位上不为0
        for (int i = 0; i < 32; ++i) {
            if (bits[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}