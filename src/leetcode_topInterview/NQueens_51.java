package leetcode_topInterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NQueens_51 {

    private int n;

    // 记录某一列是否放置了皇后
    private boolean[] col;

    // 记录主对角线上的单元格是否放置了皇后
    private boolean[] main;

    // 记录副对角线上的单元格是否放置了皇后
    private boolean[] sub;

    private List<List<String>> res;

    // 技巧：根据行与列进行回溯，并判断主对角线和副对角线的区别
    // 找规律：主对角线：（横坐标-纵坐标固定） 副对角线：（横坐标+纵坐标固定）
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        this.n = n;
        col = new boolean[n];
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(0, deque);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !main[row - i + n - 1] && !sub[row + i]) {
                path.addLast(i);
                col[i] = true;
                main[row - i + n - 1] = true;
                sub[row + i] = true;
                dfs(row + 1, path);
                col[i] = false;
                main[row - i + n - 1] = false;
                sub[row + i] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) row.append(".");
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        NQueens_51 offer = new NQueens_51();
        List<List<String>> res = offer.solveNQueens(4);
        System.out.println(res);
    }

}
