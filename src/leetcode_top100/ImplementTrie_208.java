package leetcode_top100;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208 {

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

    public ImplementTrie_208() {
        root = new Node();
    }

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

}
