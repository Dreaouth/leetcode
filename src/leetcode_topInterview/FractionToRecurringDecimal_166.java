package leetcode_topInterview;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            stringBuilder.append("-");
        }
        // 不加 Long.valueOf会导致 abs(-2147483648) overflows
        long numer = Math.abs(Long.valueOf(numerator));
        long denomin = Math.abs(Long.valueOf(denominator));
        stringBuilder.append(String.valueOf(numer / denomin));
        Long remainder = numer % denomin;
        Map<Long, Integer> map = new HashMap<>();
        if (remainder == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                stringBuilder.insert(map.get(remainder), "(");
                stringBuilder.append(")");
                break;
            }
            map.put(remainder, stringBuilder.length());
            remainder *= 10;
            stringBuilder.append(String.valueOf(remainder / denomin));
            remainder = remainder % denomin;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal_166 offer = new FractionToRecurringDecimal_166();
        String res = offer.fractionToDecimal(4, 333);
        System.out.println(res);
    }
}
