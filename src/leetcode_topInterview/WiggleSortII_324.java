package leetcode_topInterview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WiggleSortII_324 {

    // 先通过快速选择法找到中位数，然后
    public void wiggleSort(int[] nums) {
        int middle = quickSelect(nums, 0, nums.length - 1);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println(middle);
        int mid = nums[middle];
        int t = 0, j = 0, k = nums.length - 1;
        while (j < k) {
            if (nums[j] > mid) {
                swap(nums, j, k);
                --k;
            } else if (nums[j] < mid) {
                swap(nums, j, t);
                ++t;
                ++j;
            } else {
                ++j;
            }
        }
        if (nums.length % 2 == 1) middle++;
        int[] tmp1 = Arrays.copyOfRange(nums, 0, middle);
        int[] tmp2 = Arrays.copyOfRange(nums, middle, nums.length);
        for(int i = 0; i < tmp1.length; ++i){
            nums[2 * i] = tmp1[tmp1.length - 1 - i];
        }
        for(int i = 0; i < tmp2.length; ++i){
            nums[2 * i + 1] = tmp2[tmp2.length - 1 - i];
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            if (l < r) nums[l++] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            if (l < r) nums[r--] = nums[l];
        }
        nums[l] = pivot;
        if(l == nums.length / 2) {
            return l;
        } else if (l > nums.length / 2) {
            return quickSelect(nums, left, l - 1);
        } else {
            return quickSelect(nums, l + 1, right);
        }
    }

    public static void main(String[] args) {
        WiggleSortII_324 offer = new WiggleSortII_324();
        int[] nums = {5,3,1,2,6,7,8,5,5};
        offer.wiggleSort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

}
