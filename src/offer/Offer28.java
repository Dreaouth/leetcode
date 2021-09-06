package offer;

//数组中出现次数超过一半的数字
public class Offer28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        int mode = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum == 0) mode = array[i];
            if (array[i] != mode) {
                sum += 1;
            }
            else {
                sum -= 1;
            }
        }
        sum = 0;
        for (int a : array) {
            if (a == mode) {
                sum++;
            }
        }
        if (sum <= array.length / 2) {
            mode = 0;
        }
        return mode;
    }

    public static void main(String[] args) {
        Offer28 offer28 = new Offer28();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int res = offer28.MoreThanHalfNum_Solution(arr);
        System.out.println(res);
    }
}
