package offer;

// 变态跳台阶
public class Offer9 {

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 2;
        for (int i = 3; i <= target; i++) {
            sum = sum*2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Offer9 offer9 = new Offer9();
        int res = offer9.JumpFloorII(5);
        System.out.println(res);
    }
}
