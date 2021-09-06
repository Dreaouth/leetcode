package leetcode_topInterview;

public class FindPeakElement_162 {

    // O(logn) 二分查找
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid1 = (start + end) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                start = mid2;
            } else {
                end = mid1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        FindPeakElement_162 offer = new FindPeakElement_162();
        int[] nums = {1,2,1,3,5,6,4};
        int res = offer.findPeakElement(nums);
        System.out.println(res);
    }
}
