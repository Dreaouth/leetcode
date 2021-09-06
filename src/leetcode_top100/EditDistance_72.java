package leetcode_top100;

// 72. 字符串的编辑距离(***)
public class EditDistance_72 {

    /* 操作数包括删除一个字符、插入一个字符、修改一个字符
    插入操作，则比较word1[0..i]和word2[0..j-1]的结果（插入了一个word2[j]的字母，所以抵消了，向前比较）
    删除操作，则比较word1[0..i-1]和word2[0..j]的结果
    替换操作，则比较word1[0..i-1]和word2[0..j-1]的结果
                                          0                                   i=0,j=0
      edit[i][j] =                        j                                   i=0,j>0
                                          i                                   i>0,j=0                 0  a[i] = b[i]
                   min(edit[i-1][j]+1,edit[i][j-1]+1,edit[i-1][j-1]+flag)     i>0,j>0  ，  其中 flag = 1  a[i] != b[i]
     */
    public int minDistance(String word1, String word2) {
        // dp[i][j]表示从word1中0到i的字串变为word2中0到j的字串需要执行操作的次数
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        // 因为包含空字符串的比较，所以要+1
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int min(int a, int b, int c) {
        int min = a;
        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        return min;
    }

    public static void main(String[] args) {
        EditDistance_72 offer = new EditDistance_72();
        int res = offer.minDistance("intention", "execution");
        System.out.println(res);
    }
}
