package leetcode_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllNumbersDisappearedInAnArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i+1) && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i+1)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // 只加位置适合的数字，没有被加的说明没有这个数字
        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray_448 offer = new FindAllNumbersDisappearedInAnArray_448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = offer.findDisappearedNumbers_2(nums);
        System.out.println(res);
    }
}
