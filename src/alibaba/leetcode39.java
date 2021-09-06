package alibaba;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), candidates, 0, target, 0);
        return list;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int sum, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
        } else if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                dfs(res, temp, candidates, sum + candidates[i], target, i);
                temp.remove(temp.size() - 1);
            }
        }

    }


}
