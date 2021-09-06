package leetcode_top100;

public class FindFirstAndLastPositionElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0 ) {
            res[0] = res[1] = -1;
            return res;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            res[0] = res[1] = -1;
            return res;
        }
        res[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionElementInSortedArray_34 offer = new FindFirstAndLastPositionElementInSortedArray_34();
        int[] nums = {};
        int[] res = offer.searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}
