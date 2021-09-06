package offer;

import java.util.HashMap;

// 数组中只出现一次的数字
public class Offer40 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1 && count == 0) {
                count++;
                num1[0] = array[i];
            } else if (map.get(array[i]) == 1 && count == 1) {
                num2[0] = array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 1 , 7, 45, 35, 5, 3, 45, 7, 1, 98};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        Offer40 offer40 = new Offer40();
        offer40.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
