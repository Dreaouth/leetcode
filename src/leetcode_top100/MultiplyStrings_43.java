package leetcode_top100;

//43. Multiply Strings（**）
public class MultiplyStrings_43 {

    // 用数组的方式，先定义一个 num1.length + num2.length长度的数组
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] strs = new int[m + n];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int end = i + j + 1;
                int second = i + j;
                temp += strs[end];
                strs[second] += temp / 10;
                strs[end] = temp % 10;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != 0 || res.length() != 0) {
                res.append(strs[i]);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings_43 offer = new MultiplyStrings_43();
        String res = offer.multiply("123", "456");
        System.out.println(res);
    }

}
