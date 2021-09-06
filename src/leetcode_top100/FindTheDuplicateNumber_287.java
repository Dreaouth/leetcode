package leetcode_top100;

public class FindTheDuplicateNumber_287 {

    public int findDuplicate(int[] nums) {
        int index = 1;
        while (index <= nums.length) {
            System.out.println(nums[index - 1]);
            if (nums[index - 1] == index) {
                index++;
            } else if (nums[index - 1] != index && nums[index - 1] != nums[nums[index - 1] - 1]) {
                System.out.println("swap" + (index - 1) + " " + nums[index - 1]);
                swap(nums, index - 1, nums[index - 1] - 1);
            } else {
                return nums[index - 1];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber_287 offer = new FindTheDuplicateNumber_287();
        int[] nums = {2,2,2};
        int res = offer.findDuplicate(nums);
        System.out.println(res);
    }

}
