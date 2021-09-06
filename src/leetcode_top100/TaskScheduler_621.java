package leetcode_top100;

import java.util.*;

public class TaskScheduler_621 {

    // 桶方法贪心：最少的任务数取决于数量最多的那个任务
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int maxChar = 0;
        for (char c : tasks) {
            map[c - 'A']++;
            maxChar = Math.max(maxChar, map[c - 'A']);
        }
        int lastNum = 0;
        for (int num : map) {
            // 计算有多少和最大任务数相同的任务，即必须放在最后一个桶的任务
            if (num == maxChar) lastNum++;
        }
        return Math.max((maxChar-1) * (n + 1) + lastNum, tasks.length);
    }

    public static void main(String[] args) {
        TaskScheduler_621 offer = new TaskScheduler_621();
        char[] tasks = { 'A','A','A','A','A','A','B','C','D','E','F','G'};
        int res = offer.leastInterval(tasks, 2);
        System.out.println(res);
    }

}
