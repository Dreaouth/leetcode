package leetcode_dp;

public class LastStoneWeightII_1049 {

    public int lastStoneWeightII(int[] stones) {
        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            max += stones[i];
        }
        int avg = max / 2;
        boolean[] dp = new boolean[avg + 1];
        dp[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int j = avg; j >= stones[i]; j--) {
                if (dp[j - stones[i]]) dp[j] = true;
            }
        }
        int index;
        for (index = avg; index >= 0; index--) {
            if (dp[index]) break;
        }
        return max - index - index;
    }

    public static void main(String[] args) {
        LastStoneWeightII_1049 offer = new LastStoneWeightII_1049();
        int[] arr = {2, 7 ,4, 1, 8, 1};
        int res = offer.lastStoneWeightII(arr);
        System.out.println(res);
    }

}
