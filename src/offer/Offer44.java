package offer;

// 翻转单词顺序列（*）
public class Offer44 {

    public String ReverseSentence(String str) {
        // edge case
        if (str.trim().length() == 0) {
            return str;
        }
        str = str.trim();
        if (str.length() == 0) {
            return "";
        }
        int left = str.length() - 1, right = str.length() - 1;
        String res = "";
        while (left >= 0) {
            // left向左调整，和right形成一个单词
            while (left >= 0 && str.charAt(left) != ' ') left--;
            res = res.concat(str.substring(left+1, right+1) + " ");
            while (left >= 0 && str.charAt(left) == ' ') left--;
            right = left;
        }
        return res.trim();
    }

    public static void main(String[] args) {
        Offer44 offer44 = new Offer44();
        String str = "I am a student.";
        String res = offer44.ReverseSentence(str);
        System.out.println(res);
    }
}
