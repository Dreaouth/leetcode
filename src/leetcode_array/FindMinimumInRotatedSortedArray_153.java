package leetcode_array;

public class FindMinimumInRotatedSortedArray_153 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray_153 offer = new FindMinimumInRotatedSortedArray_153();
        int []nums = {7,0,1,2,4,5,6};
        int res = offer.findMin(nums);
        System.out.println(res);
    }

}
