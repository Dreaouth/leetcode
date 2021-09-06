package offer;

// 旋转数组的最小数字
public class Offer6 {

    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return -1;
        }
        else if (array.length == 1) {
            return array[0];
        }
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
//        while (low < high) {
//            if (array[mid] >= array[low] && array[mid] >= array[high]) {
//                low = mid + 1;
//            }
//            else {
//                high = mid;
//            }
//            mid = (low + high) / 2;
//        }

        // 优化思路（考虑到1 0 1 1 1 / 1 1 1 0 1的情况）
        while (low < high) {
            // 由旋转的性质可以看出，旋转后low永远大于high
            if (array[low] < array[high]) {
                return array[low];
            }
            if (array[mid] > array[low]) {
                low = mid + 1;
            }
            else if (array[mid] < array[high]){
                high = mid;
            }
            else low++;
            mid = (low + high) / 2;
        }

        return array[low];
    }

    public static void main(String[] args) {
        int[] array = {1,0,1,1,1};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }
}
