package offer;

// 斐波那契数列
public class Offer7 {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            a = b + c;
            b = c;
            c = a;
        }
        return a;
    }

    public static void main(String[] args) {
        Offer7 offer7 = new Offer7();
        int res = offer7.Fibonacci(10);
        System.out.println(res);
    }
}
