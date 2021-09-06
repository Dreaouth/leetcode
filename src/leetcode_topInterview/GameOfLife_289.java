package leetcode_topInterview;

public class GameOfLife_289 {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                check(board, i, j);
            }
        }
        for (int[] i : board) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void check(int[][] board, int i, int j) {
        if (board[i][j] == 0 || board[i][j] == 2) {
            int num = 0;
            for (int m = -1; m <= 1; m++) {
                for (int n = -1; n <= 1; n++) {
                    if (m == 0 && n == 0) continue;
                    num += judge(board, i + m, j + n) == 1 ? 1 : 0;
                }
            }
            if (num == 3) {
                board[i][j] = 2;
            }
        } else if (board[i][j] == 1 || board[i][j] == 3) {
            int num = 0;
            for (int m = -1; m <= 1; m++) {
                for (int n = -1; n <= 1; n++) {
                    if (m == 0 && n == 0) continue;
                    num += judge(board, i + m, j + n) == 1 ? 1 : 0;
                }
            }
            if (num < 2 || num > 3) {
                board[i][j] = 3;
            }
        }
    }

    private int judge(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return -1;
        }
        if (board[i][j] == 0 || board[i][j] == 2) {
            return 0;
        } else if (board[i][j] == 1 || board[i][j] == 3) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        GameOfLife_289 offer = new GameOfLife_289();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        offer.gameOfLife(board);
        for (int[] i : board) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
