package leetcode_top100;

public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        boolean res;
        initFlag(flag);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = dfs(board, i, j, word, 0, flag);
                    if (res) return true;
                }
            }
        }
        return false;
    }

    // substring耗时较长
    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] flag) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || flag[i][j]) {
            return false;
        }
        flag[i][j] = true;
        boolean res = false;
        res = dfs(board, i + 1, j,  word, index + 1, flag) || dfs(board, i - 1, j, word, index + 1, flag) ||
                dfs(board, i, j - 1,  word, index + 1, flag) || dfs(board, i, j + 1, word, index + 1, flag);
        flag[i][j] = false;
        return res;
    }

    public void initFlag(boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        WordSearch_79 offer = new WordSearch_79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean res = offer.exist(board, "ABCCED");
        System.out.println(res);
    }
}
