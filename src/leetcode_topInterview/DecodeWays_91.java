package leetcode_topInterview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DecodeWays_91 {

    // dp初步想法，dp数组当前状态和上一格状态与上两个状态有关，看能不能组成字母
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int now = chars[i] - '0';
            if (now != 0) {
                dp[i + 1] += dp[i];
            }
            int last = chars[i - 1] - '0';
            if (last != 0 && (last*10 + now) >= 1 && (last*10 + now) <= 26){
                dp[i + 1] += dp[i - 1];
            }
        }
        System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList()));
        return dp[chars.length];
    }

    public static void main(String[] args) {
        DecodeWays_91 offer = new DecodeWays_91();
        int s = offer.numDecodings("1011");
        System.out.println(s);
    }
}
