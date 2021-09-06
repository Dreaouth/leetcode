package alibaba;

import java.util.Scanner;

public class Test3_8_1 {

    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int pos = 0;
        while (k > 0) {
            i++;
            if (pos >= arr.length || arr[pos] != i) {
                k--;
            } else {
                pos++;
            }
        }
        return i;
    }



    public static void main(String[] args) {
        Test3_8_1 test3_8_1 = new Test3_8_1();
        int[] arr = {1,3,5};
        int res = test3_8_1.findKthPositive(arr, 2);
        System.out.println(res);
    }

}
