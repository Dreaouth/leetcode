package offer;

// 数字在排序数组中出现的次数（*）
public class Offer37 {

    // 两次二分法分别寻找left和right，然后结果为(right-left+1)
    public int GetNumberOfK(int [] array , int k) {
        int l, r;
        int left = 0, right = array.length - 1;
        int mid;
        // find left （注意，这里取到<=是为了正好取到刚好不匹配的下一个）（自己是可以控制寻找数组的边界的）
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        l = right;
        System.out.println(left + " " + right);
        // find right
        left = 0;
        right = array.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        r = left;
        System.out.println(left + " " + right);
        return r - l - 1;
    }

    public static void main(String[] args) {
        Offer37 offer37 = new Offer37();
        int[] array = {1,2,3,3,3,3};
        int res = offer37.GetNumberOfK(array, 3);
        System.out.println(res);
    }
}
