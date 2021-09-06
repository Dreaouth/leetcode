package offer;

import java.util.*;

//字符串的全排列(**)
public class Offer27 {

    ArrayList<String> res = new ArrayList<>();
    char[] c;

    // DFS，每次固定一个字母
    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        return res;
    }

    void dfs(int index) {
        if (index == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        //去重
        HashSet<Character> check = new HashSet<>();
        for (int i = index; i < c.length; i++) {
            if (check.contains(c[i])) {
                continue;
            }
            check.add(c[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }

    void swap (int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Offer27 offer27 = new Offer27();
        String str = "abc";
        ArrayList<String> res = offer27.Permutation(str);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}
