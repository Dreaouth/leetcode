package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test_3_30_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int []nums = new int[n*2];
        for (int i = 0; i < n*2; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int res = 0;
        // 尽量先取小的
        if (p < 50) {
            for (int i = 0; i < n; i++) {
                res += nums[i*2] * (100 - p) + nums[i*2+1] * (p);
            }
        } else {
            // 双指针分别取两头
            for (int i = 0; i < n; i++) {
                res += nums[i] * (100 - p) + nums[n*2 - i - 1] * (p);
            }
        }
        if (res % 100 == 0) {
            System.out.println(res / 100);
        } else {
            System.out.println(res + "%");
        }
    }
}
