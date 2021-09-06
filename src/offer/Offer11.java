package offer;

// 二进制中1的个数
public class Offer11 {

    public int NumberOf1_1(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        while (n != 0) {
            int temp = n % 2;
            if (temp == 1) {
                sum += 1;
            }
            n /= 2;
        }
        return sum;
    }

    // 转换一下思路，让一个数0x01从右向左与val的每一位进行&操作来判断
    public int NumberOf1_2(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int mark = 0x01;
        while (mark != 0) {
            if ((mark&n) != 0) ++ans;
            mark <<= 1;
        }
        return ans;
    }

    //从右向左的第一位1直接判断，遇到0直接略过，那效率是不是很快
    public int NumberOf1_4(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        while (n != 0) {
            ++ans;
            n = n & (n-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer11 offer11 = new Offer11();
        int res = offer11.NumberOf1_2(31);
        System.out.println(res);
    }
}
