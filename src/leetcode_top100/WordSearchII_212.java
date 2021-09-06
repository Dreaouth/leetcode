package leetcode_top100;

import java.util.*;

public class WordSearchII_212 {

    private static class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            next = new HashMap<>();
        }

        public Node(boolean isWord) {
            this();
            this.isWord = isWord;
        }
    }

    private Node root;


    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (!node.next.containsKey(c)) {
                node.next.put(c, new Node());
            }
            node = node.next.get(c);
        }
        if (!node.isWord) {
            node.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (!node.next.containsKey(c)) {
                return false;
            } else {
                node = node.next.get(c);
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        char[] words = prefix.toCharArray();
        for (char c : words) {
            if (!node.next.containsKey(c)) {
                return false;
            } else {
                node = node.next.get(c);
            }
        }
        return true;
    }

    public boolean startChar(char c) {
        Node node = root;
        return node.next.containsKey(c);
    }

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String word : words) {
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (startChar(board[i][j])) {
                    dfs(board, i, j, "", flag);
                }
                //initFlag(flag);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, String prefix, boolean[][] flag) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j]) {
            return;
        }
        prefix += board[i][j];
        if (!startsWith(prefix)) {
            return;
        }
        if (search(prefix)) {
            res.add(prefix);
        }
        flag[i][j] = true;
        dfs(board, i - 1, j, prefix, flag);
        dfs(board, i + 1, j, prefix, flag);
        dfs(board, i, j - 1, prefix, flag);
        dfs(board, i, j + 1, prefix, flag);
        flag[i][j] = false;
    }

    public void initFlag(boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j] = false;
            }
        }
    }

}
