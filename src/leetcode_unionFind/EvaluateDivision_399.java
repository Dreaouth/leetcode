package leetcode_unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision_399 {
    public class UnionFind {

        private int[] parent;

        // 节点指向父节点的权值
        private double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        // 隔代压缩
        private int find2(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]]; // 隔代压缩
                x = parent[x];
            }
            return x;
        }

        // 路径压缩（递归）
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] = weight[x] * weight[origin];
            }
            return parent[x];
        }

        public void union(int x, int y, double values) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * values / weight[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0;
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind(2 * equations.size());
        Map<String, Integer> map = new HashMap<>(2 * equations.size());
        int id = 0;
        // 第一步：预处理
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String str1 = equation.get(0);
            if (!map.containsKey(str1)) {
                map.put(str1, id);
                id++;
            }
            String str2 = equation.get(1);
            if (!map.containsKey(str2)) {
                map.put(str2, id);
                id++;
            }
            unionFind.union(map.get(str1), map.get(str2), values[i]);
        }
        // 第二步：做查询
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            Integer id1 = map.get(str1);
            Integer id2 = map.get(str2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }
}
