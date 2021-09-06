package alibaba;

import java.util.Arrays;
import java.util.Scanner;

/*
### 总结

- 组合问题
`dp[i] += dp[i - num]`
- True、False问题
`dp[i] = dp[i] or dp[i - num]`
- 最大最小问题公式
`dp[i] = min(dp[i], dp[i - num] + 1)或者dp[i] = max(dp[i], dp[i - num] + 1)`

#### 当拿到一个问题后，首先做如下判断：

1. 分析是否为背包问题
2. 是3种类型的问题中的哪种
3. 是0-1背包问题还是完全背包问题（num中的元素是否可以重复使用）
4. 如果是组合问题，是否需要考虑元素之间的顺序

#### 技巧

1. 如果是0-1背包，即数组中的元素不可重复使用，nums放在外循环，target放在内循环，且内循环倒序
2. 如果是完全背包，且数组中的元素可以重复使用，nums放在外循环，target放在内循环，且内循环正序
3. 如果组合问题需要考虑元素之间的顺序，需要将target放在外循环，将nums放在内循环

 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String lines = scanner.nextLine();
            String []strs = lines.split(" ");
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i++) {
                System.out.print(strs[i]);
                if (i != strs.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
