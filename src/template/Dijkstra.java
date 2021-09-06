package template;


import java.util.*;

public class Dijkstra {
    /*
     * 参数adjMatrix:为图的权重矩阵，权值为-1的两个顶点表示不能直接相连
     * 函数功能：返回顶点0到其它所有顶点的最短距离，其中顶点0到顶点0的最短距离为0
     */
    Map<Integer, Integer> dist;


    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 初始化邻接表
        for (int[] t : times) {
            map.computeIfAbsent(t[0], k -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        // 初始化dis数组和vis数组
        int[] dis = new int[N + 1];
        Arrays.fill(dis, 0x3f3f3f3f);
        boolean[] vis = new boolean[N + 1];

        // 起点的dis为0，但是别忘记0也要搞一下，因为它是不参与的，我计算结果的时候直接用了stream，所以这个0也就要初始化下了
        dis[K] = 0;
        dis[0] = 0;

        // new一个小堆出来，按照dis升序排，一定要让它从小到大排，省去了松弛工作
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> dis[o1] - dis[o2]);
        // 把起点放进去
        queue.offer(K);

        while (!queue.isEmpty()) {
            // 当队列不空，拿出一个源出来
            Integer poll = queue.poll();
            if(vis[poll]) continue;
            // 把它标记为访问过
            vis[poll] = true;
            // 遍历它的邻居们，当然可能没邻居，这里用getOrDefault处理就很方便
            List<int[]> list = map.getOrDefault(poll, Collections.emptyList());
            for (int[] arr : list) {
                int next = arr[0];
                // 如果这个邻居访问过了，继续
                if (vis[next]) continue;
                // 更新到这个邻居的最短距离，看看是不是当前poll出来的节点到它更近一点
                dis[next] = Math.min(dis[next], dis[poll] + arr[1]);
                queue.offer(next);
            }
        }
        // 拿到数组中的最大值比较下，返回结果
        int res = Arrays.stream(dis).max().getAsInt();
        return res == 0x3f3f3f3f ? -1 : res;
    }

    public int networkDelayTime_dij(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    // 相当于基于BFS的优化
    public int networkDelayTime_SPFA(int[][] times, int N, int K) {
        int[][] g = new int[N + 1][N + 1];
        // 初始化 graph
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                g[i][j] = i == j ? 0 : -1;
            }
        }
        // 单向边
        for (int[] t : times) {
            g[t[0]][t[1]] = t[2];
        }

        int INF = 0x3f3f3f3f;
        // 初始化 dis、vis
        int[] dis = new int[N + 1];
        Arrays.fill(dis, INF);
        dis[0] = dis[K] = 0;

        boolean[] vis = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K);
        vis[K] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            vis[poll] = false;
            // 遍历邻居
            for (int next = 1; next <= N; next++) {
                // 如果是邻居 且 如果没有更新过，或者是需要更新，才往下走，注意这里是且，并不是判断了邻居就往下走了
                // 下面是错误写法，如果图中有环，在不需要更新的情况下，就能重复入队，就是死循环了
             /*
            if (edge[poll][i] != -1) {
                //更新
                if (dis[i] == INF || dis[i] > dis[poll] + edge[poll][i]) {
                    dis[i] = dis[poll] + edge[poll][i];
                }
                if (!vis[i]) {
                    vis[i] = true;
                    queue.offer(i);
                }
            }
             */
                int w = g[poll][next];
                // 如果是邻居 且 需要更新，才能进去更新
                if (w != -1 && (dis[next] == INF || dis[next] > dis[poll] + w)) {
                    dis[next] = dis[poll] + w;
                    // 如果队列中没有，就可以入队，不要重复入队
                    if (!vis[next]) {
                        vis[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        int res = Arrays.stream(dis).max().getAsInt();
        return res == INF ? -1 : res;
    }


}
