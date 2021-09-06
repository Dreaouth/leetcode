package leetcode_top100;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            // 两种方法，剑指offer用的是交换法，此处用的是tempList循环法，耗时短一些
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                dfs(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public void dfs2(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            ArrayList<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
            res.add(temp);
        } else {
            HashSet<Integer> check = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (check.contains(nums[i])) continue;
                check.add(nums[i]);
                swap(nums, i, index);
                dfs2(res, nums, index+1);
                swap(nums, i , index);
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Permutations_46 offer = new Permutations_46();
        int[] num = {1, 2, 3};
        List<List<Integer>> res = offer.permute(num);
        System.out.println(res);
    }
}
