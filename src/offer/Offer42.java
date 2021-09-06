package offer;

import java.util.ArrayList;

// 和为S的两个数字
public class Offer42 {

    // 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
    // 最外侧的乘积越小，所以可以直接使用双指针法返回
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if ((array[left] + array[right]) < sum) {
                left++;
            } else if ((array[left] + array[right]) > sum) {
                right--;
            } else {
                res.add(array[left]);
                res.add(array[right]);
                break;
            }
        }
        if (left == right) {
            System.out.println("No");
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 7, 8, 10, 23, 35, 47, 66, 69, 78, 90, 100};
        int sum = 76;
        Offer42 offer42 = new Offer42();
        ArrayList<Integer> res = offer42.FindNumbersWithSum(array, sum);
        System.out.println(res.get(0) + " " + res.get(1));
    }
}
