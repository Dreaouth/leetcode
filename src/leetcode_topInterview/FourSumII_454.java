package leetcode_topInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSumII_454 {

    // 初步想法：空间换时间，先用hashmap存储A和B的和，再遍历CD看是否满足条件
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            for (int k : B) {
                int temp = -(j + k);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        int res = 0;
        for (int i : C) {
            for (int j : D) {
                if (map.containsKey(i + j)) {
                    res += map.get(i + j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
