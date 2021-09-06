package leetcode_topInterview;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                int power = n % 10;
                temp += (power * power);
                n /= 10;
            }
            n = temp;
            if (set.contains(n)) {
                break;
            }
            set.add(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        HappyNumber_202 offer = new HappyNumber_202();
        boolean res = offer.isHappy(2);
        System.out.println(res);
    }

}
