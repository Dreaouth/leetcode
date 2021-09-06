package offer;

import java.util.Arrays;

// 表示数值的字符串
public class Offer53 {

    //+100","5e2","-123","3.1416"和"-1E-16"都表示数值
    //"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是数值
    public boolean isNumeric(char[] str) {
        boolean isNum = false;
        boolean isDot = false;
        boolean isE = false;
        if (str.length == 0) {
            return false;
        } else if (str[0] == '+' || str[0] == '-') {
            str = Arrays.copyOfRange(str, 1, str.length);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
            if (str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            } else if (str[i] == '.') {
                if (isDot || isE) {
                    return false;
                }
                isDot = true;
            } else if (str[i] == 'E' || str[i] == 'e') {
                System.out.println("i=" + i);
                System.out.println("str=" + str[i]);
                if (!isNum || isE) {
                    return false;
                } else if (i == str.length - 1) {
                    return false;
                }
                isDot = true;
                isE = true;
                isNum = false;
                if (str[i+1] == '-' || str[i+1] == '+') {
                    i++;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Offer53 offer53 = new Offer53();
        String str = "-.123";
        boolean res = offer53.isNumeric(str.toCharArray());
        System.out.println(res);
    }
}
