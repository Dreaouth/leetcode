package offer;

// 矩阵中的路径
public class Offer65 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        Boolean[][] flag = new Boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    System.out.println("once judge" + i + j);
                    initFlag(flag);
                    if (dfs(board, i, j, word, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void initFlag(Boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j] = false;
            }
        }
    }

    public boolean dfs(char[][] board, int i, int j, String word, Boolean[][] flag) {
        System.out.println(word + "i=" + i + " j=" + j);
        if (word.equals("")) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] || board[i][j] != word.charAt(0)) {
            return false;
        }
        flag[i][j] = true;
        if (dfs(board, i - 1, j, word.substring(1), flag) || dfs(board, i + 1, j, word.substring(1), flag)
                || dfs(board, i, j - 1, word.substring(1), flag) || dfs(board, i, j + 1, word.substring(1), flag)) {
            return true;
        }
        // bug修复：之前忘记了还原 flag[i][j] = false 例如有些路径只通一半就不通，但已经将flag置为true，导致不能再走一遍该路径
        flag[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Offer65 offer65 = new Offer65();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        Boolean flag = offer65.exist(board, "ABCESEEEFS");
        System.out.println(flag);
    }
}
