package offer;

// 把字符串转化成整数
public class Offer49 {

    public int strToInt(String str) {
        int i = 0;
        double num = 0;
        boolean neg = true;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        } else if (str.charAt(i) == '-') {
            neg = false;
            i++;
        } else if (str.charAt(i) == '+') {
            neg = true;
            i++;
        }
        str = str.substring(i);
        i = 0;
        while (i < str.length()) {
            int n = str.charAt(i) - 48;
            if (n < 0 || n > 9) {
                break;
            }
            num = num * 10 + n;
            i++;
        }
        num = neg ? num : -num;
        if (num > Math.pow(2, 31) - 1) {
            num = (int) (Math.pow(2, 31) - 1);
        } else if (num < -Math.pow(2, 31)) {
            num = (int)-Math.pow(2, 31);
        }
        return (int) num;
    }

    public static void main(String[] args) {
        Offer49 offer49 = new Offer49();
        int res = offer49.strToInt("-91283472332");
        System.out.println(res);
    }
}
