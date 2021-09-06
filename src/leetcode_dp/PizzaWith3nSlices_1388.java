package leetcode_dp;


// 与打家劫舍2不同，可取总数有限制，必须是n / 3
public class PizzaWith3nSlices_1388 {

    // dp[i][j]表示在前i个数中选择了j个不相邻的数的最大和
    // 1. 如果我们选择了第i个数，那么第i - 1个数不能被选择，相当于需要在前i - 2个数中选择j - 1个
    //   dp[i][j]=dp[i−2][j−1]+slices[i]
    // 2. 如果我们没有选择第i个数，那么需要在前i - 1个数中选择j个
    //   dp[i][j]=dp[i−1][j]
    //  dp[i][j]=max(dp[i−2][j−1]+slices[i],dp[i−1][j])
    public int maxSizeSlices(int[] slices) {
        return Math.max(maxSize(slices, 0, slices.length - 2), maxSize(slices, 1, slices.length - 1));
    }

    public int maxSize(int[] slices, int start, int end) {
        int choose = (slices.length + 1) / 3;
        int [][]dp = new int[slices.length + 1][choose + 1];
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= choose; j++){
                dp[i + 1][j] = Math.max((i - 1 >= 0 ? dp[i - 1][j - 1] : 0) + slices[i], dp[i][j]);
            }
        }
        return dp[end + 1][choose];
    }

    public static void main(String[] args) {
        PizzaWith3nSlices_1388 offer = new PizzaWith3nSlices_1388();
        int[] slices = {3,5,4,4,6,6,3,4,4,7,10,5,7,2,2};
        int res = offer.maxSizeSlices(slices);
        System.out.println(res);
    }
}
