package leetcode_top100;

public class IntegerToRoman_12 {

    public String intToRoman(int num) {
        String[] sym = {"MMM", "MM", "M", "CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C", "XC", "LXXX", "LXX", "LX", "L", "XL",
                "XXX", "XX", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        int[] val = {3000, 2000, 1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            if (num >= val[i]) {
                res.append(sym[i]);
                num -= val[i];
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        IntegerToRoman_12 offer = new IntegerToRoman_12();
        String res = offer.intToRoman(91);
        System.out.println(res);
    }
}
