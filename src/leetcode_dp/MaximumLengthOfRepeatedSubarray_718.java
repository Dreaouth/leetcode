package leetcode_dp;

public class MaximumLengthOfRepeatedSubarray_718 {

    // 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀
    public int findLength_dp(int[] A, int[] B) {
        int [][]dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = (A[i] == B[j]) ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    // 滑动窗口做法
    public int findLength_slideWindow(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    public int findMax(int []A, int []B) {
        int max = 0;
        int an = A.length, bn = B.length;
        // 分为三个部分，由于规定每次都是A为较短的数组，B为较长的数组
        // 1. 从A[0]开始，B数组从末尾从前向后移动，长度分别递增，直到等于A长度
        // 2. 从A[0]开始，B数组从与A等长处开始，长度一直为A，直到等于B长度
        // 3. 从A[1]开始，B数组不动，长度分别递减，直到A数组移出界外
        for (int i = 0; i < an; i++) {
            max = Math.max(max, maxLen(A, 0, B, bn - i - 1, i + 1));
        }
        for (int i = 0; i < bn - an; i++) {
            max = Math.max(max ,maxLen(A, 0, B, bn - an - i - 1, an));
        }
        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }
        return max;
   }

   public int maxLen(int []A, int i, int []B, int j, int len) {
       int count = 0, max = 0;
       for(int k = 0; k < len; k++) {
           if(A[i+k] == B[j+k]) {
               count++;
           } else if(count > 0) {
               max = Math.max(max, count);
               count = 0;
           }
       }
       return count > 0 ? Math.max(max, count) : max;
   }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray_718 offer = new MaximumLengthOfRepeatedSubarray_718();
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        int res = offer.findLength_slideWindow(A, B);
        System.out.println(res);
    }
}
