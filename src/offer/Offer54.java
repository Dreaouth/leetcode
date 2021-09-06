package offer;

import java.util.HashMap;

// 字符流中第一个不重复的字符
public class Offer54 {

    // 哈希表 + 队列， 空间复杂度O(n)
    HashMap<Character, Boolean> map = new HashMap<>();
    String str = "";
    int lastOnce = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.get(ch) != null && map.get(ch)) {
            map.put(ch, false);
            str += ch;
            if (ch == str.charAt(lastOnce)) {
                while (lastOnce < str.length() && !map.get(str.charAt(lastOnce))) {
                    System.out.println(lastOnce);
                    lastOnce++;
                }
            }
        } else {
            map.put(ch, true);
            str += ch;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (lastOnce == str.length()) {
            return '#';
        }
        return str.charAt(lastOnce);
    }

    public static void main(String[] args) {
        Offer54 offer54 = new Offer54();
        offer54.Insert('g');
        offer54.Insert('o');
        offer54.Insert('o');
        offer54.Insert('g');
        offer54.Insert('l');
        offer54.Insert('e');
        char res = offer54.FirstAppearingOnce();
        System.out.println(res);
    }
}
