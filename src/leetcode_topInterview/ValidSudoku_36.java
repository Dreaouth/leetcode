package leetcode_topInterview;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    int block =  (i / 3 * 3) + (j / 3);
                    if (set.contains("r" + i + val) || set.contains("c" + j + val) || set.contains("b" + block + val)) {
                        return false;
                    } else {
                        set.add("r" + i + val);
                        set.add("c" + j + val);
                        set.add("b" + block + val);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
