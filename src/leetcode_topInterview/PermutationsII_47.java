package leetcode_topInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new HashSet<>(), new HashSet<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, Set<List<Integer>> set, Set<Integer> used) {
        if (tempList.size() == nums.length) {
            if (!set.contains(tempList)) {
                res.add(new ArrayList<>(tempList));
                set.add(new ArrayList<>(tempList));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) continue;
            tempList.add(nums[i]);
            used.add(i);
            dfs(res, tempList, nums, set, used);
            tempList.remove(tempList.size() - 1);
            used.remove(i);
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 offer = new PermutationsII_47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = offer.permuteUnique(nums);
        System.out.println(res);
    }

}
