package leetcode_top100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 字符串解码（**）
public class DecodeString_394 {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> kStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int mult = 0;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9'){
                // 数字可能大于10
                mult = mult*10 + (c - '0');
            } else if (c == '[') { // 当遇到[时，将前面的字符都入栈
                kStack.push(res);
                numStack.push(mult);
                res = new StringBuilder();
                mult = 0;
            } else if(c >= 'a' && c <= 'z') {
                res.append(c);
            }else if (c == ']') {
                int tempNum = numStack.pop();
                StringBuilder ansTmp = kStack.pop();
                for (int i = 0; i < tempNum; i++) {
                    ansTmp.append(res);
                }
                res = ansTmp;
            }
            index++;
        }
        return res.toString();
    }


    public static void main(String[] args) {
        DecodeString_394 offer = new DecodeString_394();
        String res = offer.decodeString("3[a]2[bc]");
        System.out.println(res);
    }
}
