package leetcode_string;

import java.util.Arrays;

public class ReverseWordsInAString_151 {

    public String reverseWords(String s) {
        s = s.trim();
        String []strs = s.split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]);
            if (i != 0) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString_151 offer = new ReverseWordsInAString_151();
        String str = "  Bob    Loves  Alice   ";
        String res = offer.reverseWords(str);
        System.out.println(res);
    }
}
