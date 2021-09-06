package offer;

public class Offer47 {

    // 递归短路：对于&&语句，在第一个为 false 时，不会执行第二个条件
    public int Sum_Solution(int n) {
        boolean flag = n > 0 && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        Offer47 offer47 = new Offer47();
        int res = offer47.Sum_Solution(5);
        System.out.println(res);
    }
}
