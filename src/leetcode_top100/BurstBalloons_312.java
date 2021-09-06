package leetcode_top100;


// 312. Burst Balloons(****)
public class BurstBalloons_312 {

    // 令 dp[i][j] 表示填满开区间 (i,j)(i,j) 能得到的最多硬币数
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            val[i] = nums[i - 1];
        }
        // i是左，k是中，j是右
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(sum, rec[i][j]);
                }
            }
        }
        return rec[0][n + 1];
    }

    public static void main(String[] args) {
        BurstBalloons_312 offer = new BurstBalloons_312();
        int[] nums = {3,1,5,8};
        int res = offer.maxCoins(nums);
        System.out.println(res);
    }
}
