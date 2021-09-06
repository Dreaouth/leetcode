package leetcode_topInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// (****)
public class CountOfSmallerNumbersAfterSelf_315 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        int[] temp = new int[len];
        int[] res = new int[len];

        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, nums.length - 1, indexes, temp, res);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
    }

    //使用到了索引数组的特定，比较的是索引对应的数字，而真正操作的是索引
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;
                res[indexes[k++]] +=  (j - mid - 1);
            } else {
                indexes[k++] = temp[j];
                j++;
            }
        }
        while (i <= mid) {
            indexes[k] = temp[i];
            res[indexes[k++]] += (right - mid);
            i++;
        }
        while (j <= right) {
            indexes[k++] = temp[j];
            j++;
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf_315 offer = new CountOfSmallerNumbersAfterSelf_315();
        int[] nums = {5, 2, 6, 1};
        List<Integer> res = offer.countSmaller(nums);
        System.out.println(res);
    }

}
