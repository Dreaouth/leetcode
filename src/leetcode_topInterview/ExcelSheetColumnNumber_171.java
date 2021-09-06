package leetcode_topInterview;

public class ExcelSheetColumnNumber_171 {

    public int titleToNumber(String s) {
        char[] cc = s.toCharArray();
        int num = 1;
        int res = 0;
        for (int i = cc.length - 1; i >= 0; i--) {
            res += num * (cc[i] - 'A' + 1);
            num *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 offer = new ExcelSheetColumnNumber_171();
        int res = offer.titleToNumber("ZAY");
        System.out.println(res);
    }
}
