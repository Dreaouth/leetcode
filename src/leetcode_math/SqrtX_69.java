package leetcode_math;

public class SqrtX_69 {

    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long)mid * mid == x) {
                return mid;
            }
            if ((long)mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SqrtX_69 test = new SqrtX_69();
        int res = test.mySqrt(2147395599);
        System.out.println(res);
    }
}
