package offer;

import java.util.ArrayList;

// 最小的k个数
public class Offer29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[j] < input[j-1]) {
                    swap(input, j, j-1);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void swap (int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
        int[] array = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = offer29.GetLeastNumbers_Solution(array, 4);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }


}
