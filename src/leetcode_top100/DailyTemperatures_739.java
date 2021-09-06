package leetcode_top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = i - index;
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures_739 offer = new DailyTemperatures_739();
        int[] T = {89,62,70,58,47,47,46,76,100,70};
        int[] res = offer.dailyTemperatures(T);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
