package alibaba;

import java.util.Scanner;
import java.util.Stack;

/*
小强得到了长度为n的序列，但他只对非常大的数字感兴趣，因此随机选择这个序列的一个连续子序列，
并求这个序列的最大值，请告诉他这个最大值的期望是多少?

输入 第一行n表示序列长度接下来一行n个数描述这个序列，n大于等于1小于等于1000000，数字保证是正整数且不超过100000 第二行n个数字表示序列的值
输出 保留6位小数
 */
public class Test3_30_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        double total = (double) n * (n + 1) / 2;
        Stack<Integer> stack = new Stack<>();
        double ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int last = stack.pop();
                int rem;
                if (stack.isEmpty()) {
                    rem = last + 1;
                } else {
                    rem = last - stack.peek();
                }
                double temp = 1.0 * nums[last] * (rem) * (i - last);
                ans += temp  / total;
            }
            stack.push(i);
        }
        System.out.println("ok");
        while (!stack.isEmpty()) {
            int last = stack.pop();
            int rem;
            if (stack.isEmpty()) {
                rem = last + 1;
            } else {
                rem = last - stack.peek();
            }
            double temp = 1.0 * nums[last] * (rem) * (nums.length - last);
            ans += temp  / total;
        }
        System.out.println(ans);
    }
}
