package offer;

// 正则表达式匹配（*）
public class Offer52 {

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() != 0 && p.length() == 0) {
            return false;
        } else if (s.length() == 0 && p.length() != 0) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            } else {
                return false;
            }
        } else {
            if (p.length() > 1 && p.charAt(1) == '*') {
                // 下面这种方式是错误的，因为没有考虑两种不同的情况 a*a 和 aaa，应返回true，下面这种方式返回false
//                int i = 0;
//                while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
//                    i++;
//                }
//                return isMatch(s.substring(i), p.substring(2));
                if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
                    return isMatch(s, p.substring(2));
                } else {
                    // 分为两种情况，样本串和模式串两种匹配情况（aaa 和 a*a 返回为true）
                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
                }
            } else {
                int i = 0;
                if (s.charAt(i) == p.charAt(i) || p.charAt(i) == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            }
        }
    }

    // "."可以表示任意一个字符， "*"可以表示它前面的字符可以出现任意次（包含0次）
    public static void main(String[] args) {
        String str = "aaaaa";
        String pattern = "a*aaaaaa";
        Offer52 offer52 = new Offer52();
        boolean res = offer52.isMatch(str, pattern);
        System.out.println(res);
    }
}
