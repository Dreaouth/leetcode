package leetcode_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 39. Combination Sum(**)
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    // 和全排列类似，依然是回溯法的思想，设置一个临时list和remain，并dfs进行检测，如果
    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int remain, int start){
        if (remain < 0) return;
        else if (remain == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            // 如果i从0开始，就相当于全排列了，比如[3,2,2]和[2,3,2]，所以i应该从start开始
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                dfs(res, tempList, candidates, remain - candidates[i], i); // 注意这里是i而不是start；另外，如果是i的话就表示可以重复，i+1表示不可重复
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 offer = new CombinationSum_39();
        int[] candidates = {2, 3, 5};
        List<List<Integer>> res = offer.combinationSum(candidates, 20);
        System.out.println(res);
    }

}
