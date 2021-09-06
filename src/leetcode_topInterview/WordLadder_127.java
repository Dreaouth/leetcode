package leetcode_topInterview;

import java.util.*;

public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第一步，将wordList加入到集合中
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        // 第二步 开始广度优先搜索
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (changeWordEveryOneLetter(currWord, endWord, queue, visited, wordSet)) {
                    return res + 1;
                }
            }
            res++;
        }
        return 0;
    }

    // 尝试对 currentWord修改每一个字符，看是不是能与endWord匹配
    public boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) continue;
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    // 如果之前没有遍历过该节点，说明其可以放在下一次进行遍历
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        WordLadder_127 offer = new WordLadder_127();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        int res = offer.ladderLength("hit", "cog", wordList);
        System.out.println(res);
    }
}
