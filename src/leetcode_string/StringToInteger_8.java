package leetcode_string;

public class StringToInteger_8 {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }
        char []str = s.toCharArray();
        int index = 0;
        int flag = 1;
        if (str[index] == '-' || str[index] == '+') {
            flag = str[index] == '-' ? -1 : 1;
            index++;
        }
        int left, right;
        right = left = index;
        int res = 0;
        while (index < str.length) {
            char temp = str[index];
            if (temp > '9' || temp < '0') {
                break;
            } else {
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (temp - '0') > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (temp - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + flag * (temp - '0');
                right++;
            }
            index++;
        }
        if (left == right) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        StringToInteger_8 offer = new StringToInteger_8();
        int res = offer.myAtoi("200000000000000000");
        System.out.println(res);
    }
}
