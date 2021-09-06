package template;

import java.util.LinkedList;

public class Graph {
    private int size; // 顶点数量
    private int[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    private boolean[] isVisited;
    private static final int MAX_WEIGHT = 10000;

    public Graph(int size) {
        super();
        this.size = size;
        vertexs = new int[size];
        for (int i = 0; i < size; i++) {
            vertexs[i] = i;
        }
        matrix = new int[size][size];
        isVisited = new boolean[size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    /*
     * 获取指定顶点的第一个邻接点
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] != 0 && matrix[index][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 根据前一个邻接点的下标来获取下一个邻接点
     *
     * @param v 表示要找的顶点
     *
     * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     */
    public int getNextNeighbor(int v, int index) {
        for (int i = (index + 1); i < size; i++) {
            if (matrix[v][i] != 0 && matrix[v][i] != MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 深度优先遍历
     */
    public void DFS(int i) {
        isVisited[i] = true;
        int weight = getFirstNeighbor(i);
        while (weight != -1) {
            if (!isVisited[weight]) {
                System.out.print("v" + weight + " ");
                DFS(weight);
            }
            weight = getNextNeighbor(i, weight);
        }
    }

    /*
     * 提供访问的DFS,强制每一次的遍历，防止在有向图和非连通图中有些顶点访问不到的情况
     */
    public void DFS() {
        isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                System.out.print("v" + i + " ");
                DFS(i);
            }
        }
        isVisited = new boolean[size];
    }

    /*
     * 广度优先遍历
     */
    public void BFS(int i) {
        int temp, weight;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("v" + i + " ");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst().intValue();
            weight = getFirstNeighbor(temp);
            while (weight != -1) {
                if (!isVisited[weight]) {
                    System.out.print("v" + weight + " ");
                    isVisited[weight] = true;
                    queue.add(weight);
                }
                weight = getNextNeighbor(temp, weight);
            }
        }
    }

    /*
     * 提供访问的BFS,强制每一次的遍历，防止在有向图和非连通图中有些顶点访问不到的情况
     *
     */
    public void BFS() {
        isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                BFS(i);
            }
        }
        isVisited = new boolean[size];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        int[] a0 = new int[] { 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
        int[] a1 = new int[] { 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
        int[] a2 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
        int[] a3 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21 };
        int[] a4 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
        int[] a5 = new int[] { 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
        int[] a6 = new int[] { MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
        int[] a7 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
        int[] a8 = new int[] { MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };
        graph.matrix[0] = a0;
        graph.matrix[1] = a1;
        graph.matrix[2] = a2;
        graph.matrix[3] = a3;
        graph.matrix[4] = a4;
        graph.matrix[5] = a5;
        graph.matrix[6] = a6;
        graph.matrix[7] = a7;
        graph.matrix[8] = a8;
        System.out.print("DFS: ");
        graph.DFS();
        System.out.println();
        System.out.print("BFS: ");
        graph.BFS();
        System.out.println();
    }
}
