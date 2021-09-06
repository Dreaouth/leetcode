package alibaba;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

// aaa bcd zzz bcdef uvwz bcdefvwzzzzzz bbbb bbbbu
public class Test3_20_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] strs = new String[t];
        int n = 0;
        for (int i = 0; i < t; i++) {
            strs[i] = scanner.next();
            n += strs[i].length();
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1 = o1.charAt(o1.length() - 1);
                int c2 = o2.charAt(o2.length() - 1);
                int c3 = o1.charAt(0);
                int c4 = o2.charAt(0);
                if (c1 != c2) {
                    return c1 - c2;
                } else {
                    return c3 - c4;
                }
            }
        });
        // dp[i]表示以第i个字符结尾所能组成的最长的旋律
        int []dp = new int[26];

        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < strs.length; i++) {
            int first = strs[i].charAt(0) - 'a';
            int last = strs[i].charAt(strs[i].length() - 1) - 'a';
            for (int j = last; j >= 0; j--) {
                if (j <= first) { // 表示当前字符串，可以与前面的连接
                    dp[last] = Math.max(dp[last], dp[j] + strs[i].length());
                } else {
                    dp[last] = Math.max(dp[last], dp[j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList()));
        System.out.println(dp[25]);
    }


}
