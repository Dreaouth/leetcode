package leetcode_top100;

public class RegularExpressionMatching_10 {

    // 递归法，也可以用dp做
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
                if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
                } else {
                    return isMatch(s, p.substring(2));
                }
            } else if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching_10 offer = new RegularExpressionMatching_10();
        System.out.println(offer.isMatch("aaaaaaaaaaaaab", "a*aaa"));
    }
}
