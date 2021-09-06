package leetcode_top100;


public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            // 分为两种情况，分别是 2,4,5,6,7,0,1 和 6,7,0,1,2,4,5
            if (nums[mid] == target) {
                return mid;
            }
            // 注意这里是大于等于***，否则当数组中只有两位数时会进入到错误的判断逻辑
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 offer = new SearchInRotatedSortedArray_33();
        int[] nums = {3, 1};
        int res = offer.search(nums, 1);
        System.out.println(res);
    }
}
