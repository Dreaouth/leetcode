package offer;

// 不用加减乘除做加法（**）
public class Offer48 {

    // 将加法分为无进位和与进位
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int and = (num1 & num2) << 1;
            num1 = num1 ^ num2;
            num2 = and;
        }
        return num1;
    }

    //递归写法
    public int Add2(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return Add2(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Offer48 offer48 = new Offer48();
        int res = offer48.Add(5, 7);
        System.out.println(res);
    }
}
