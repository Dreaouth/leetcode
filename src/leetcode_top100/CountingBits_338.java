package leetcode_top100;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// 338. Counting Bits
public class CountingBits_338 {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int pointer = 2;
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i == pointer * 2) {
                pointer *= 2;
            }
            int temp = i - pointer;
            dp[i] = dp[temp] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits_338 offer = new CountingBits_338();
        int[] res = offer.countBits(33);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
