package leetcode_math;

public class FindNDIgst_400 {

    public int findNthDigit(int n) {
        int num = 1;
        while (n > 0) {
            int temp = num;
            int last = temp;
            while (temp > 0 || last > 10) {
                System.out.println(temp);
                n--;
                if (n == 0) {
                    return temp % 10;
                }
                last = temp;
                temp = temp / 10;
            }
            num++;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindNDIgst_400 offer = new FindNDIgst_400();
        int res = offer.findNthDigit(11);
        System.out.println(res);
    }
}
