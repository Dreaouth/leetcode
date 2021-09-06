package tencent;

import java.util.Scanner;

public class Test2020_4 {

    public static class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]]; // 压缩？
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            UnionFind unionFind = new UnionFind(100000);
            int max = 0;
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                unionFind.union(x, y);
                max = Math.max(max, Math.max(x, y));
            }
            int res = 0;
            for (int i = 0; i <= max; i++) {
                int temp = 0;
                for (int j = 0; j <= max; j++) {
                    if (unionFind.isConnected(i, j)) temp++;
                }
                res = Math.max(res, temp);
            }
            System.out.println(res);
        }
    }
}
