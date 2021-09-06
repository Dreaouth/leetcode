package leetcode_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionLabels_763 {

    // 先搜索一遍，确定每个字母的左右边界，然后根据第一个字符开始贪心
    public List<Integer> partitionLabels(String S) {
        int[] right = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            right[c - 'a'] = i;
        }
        int index = 0;
        int left = 0;
        while (index < S.length()) {
            int minRight = right[S.charAt(index) - 'a'];
            left = index;
            // 找到当前left的最小right
            while (index <= minRight) {
                if (right[S.charAt(index) - 'a'] > minRight) minRight = right[S.charAt(index) - 'a'];
                index++;
            }
            res.add(minRight - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels_763 offer = new PartitionLabels_763();
        List<Integer> res = offer.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }

}
