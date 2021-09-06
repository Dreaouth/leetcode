package offer;

// 连续子数组的最大和
public class Offer30 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int maxSum = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            if (dp[i] > maxSum)
                maxSum = dp[i];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Offer30 offer30 = new Offer30();
        int []arr = {6,-3,-2,7,-15,1,2,2};
        int maxSum = offer30.FindGreatestSumOfSubArray(arr);
        System.out.println(maxSum);
    }
}
