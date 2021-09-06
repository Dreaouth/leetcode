package alibaba;

/*
给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：
你挑选 任意 一块披萨。
Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
重复上述过程直到没有披萨剩下。
每一块披萨的大小按顺时针方向由循环数组 slices 表示。
请你返回你可以获得的披萨大小总和的最大值。
 */
public class Test3_10_2 {
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
}
