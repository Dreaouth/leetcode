package offer;

// 跳台阶
public class Offer8 {

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 0;
        int a = 1;
        int b = 2;
        for (int i = 2; i < target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Offer8 offer8 = new Offer8();
        int res = offer8.JumpFloor(3);
        System.out.println(res);
    }
}
