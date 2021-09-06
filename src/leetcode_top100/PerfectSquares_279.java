package leetcode_top100;

import java.util.*;

//279. Perfect Squares(**)
public class PerfectSquares_279 {

    // dp[n] = Min{dp[n - i*i]+1}, n-i*i >=0 && i >= 1
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j*j >= 0) {
                min = Math.min(dp[i - j*j] + 1, min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }


    //方法二：BFS
    public int numSquares_BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            while(size-- > 0) {
                int u = q.poll();
                for(int i = 1; i*i <= n; i++) {
                    int v = u+i*i;
                    if(v == n) {
                        return depth;
                    }
                    if(v > n) {
                        break;
                    }
                    if(!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        PerfectSquares_279 offer = new PerfectSquares_279();
        int n = offer.numSquares(12);
        System.out.println(n);
    }

}
