package offer;

// 矩形覆盖（找规律、递推）
// 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
public class Offer10 {

    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        else if (target == 2) {
            return 2;
        }
        int sum = 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        int res = offer10.RectCover(5);
        System.out.println(res);
    }
}
