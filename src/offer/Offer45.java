package offer;

import java.util.Arrays;

// 扑克牌顺子
public class Offer45 {

    public boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int king = 0;
        int i = 0;
        while (numbers[i] == 0) {
            king++;
            i++;
        }
        i++;
        for (; i < numbers.length; i++) {
            int sub = numbers[i] - numbers[i-1];
            if (sub == 1) {
                continue;
            }
            while (sub > 1 && king > 0) {
                sub--;
                king--;
            }
            if (sub != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {0,3,0,6,7};
        Offer45 offer45 = new Offer45();
        boolean res = offer45.isContinuous(array);
        System.out.println(res);
    }
}
