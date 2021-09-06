package offer;

// 左旋转字符串
public class Offer43 {
    // 或者用三次reverse法也可以
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        for (int i = 0; i < n; i++) {
            str = str.concat(String.valueOf(str.charAt(0)));
            str = str.substring(1);
        }
        return str;
    }
    public static void main(String[] args) {
        Offer43 offer43 = new Offer43();
        String res = offer43.LeftRotateString("abcXYZdef", 3);
        System.out.println(res);
    }
}
