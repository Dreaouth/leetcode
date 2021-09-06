package template;

import java.util.Scanner;

public class Floyd {

    public static void main(String[] args) {
        int [][]e = new int[10][10];
        int n, m;
        int inf = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        // n表示顶点个数，m表示边的条数
        m = scanner.nextInt();
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) e[i][j] = 0;
                else e[i][j] = inf;
            }
        }

        for (int i = 1; i <= m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            e[from][to] = weight;
        }

        // floyd算法核心语句
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (e[i][j] > e[i][k] + e[k][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }

        for (int i = 1; i<= n; i++) {
            for (int j = 1; j<= n; j++) {
                System.out.print(e[i][j] + " ");
            }
            System.out.println();
        }
    }
}
