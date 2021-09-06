package leetcode_topInterview;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysII_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                res.add(j);
            }
            map.put(j, map.getOrDefault(j, -1) - 1);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII_350 offer = new IntersectionOfTwoArraysII_350();
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5};
        int[] res = offer.intersect(nums1, nums2);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
