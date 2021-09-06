package tencent;

import javafx.util.Pair;

import java.util.*;

public class Test2020_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int [][]nums = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j < k; j++) {
                list.add(nums[i][j] - nums[i][j - 1]);
                temp.add(nums[i][j - 1] - nums[i][j]);
            }
            if (set.contains(temp)) res++;
            set.add(list);
        }
        System.out.println(res);
    }
}

