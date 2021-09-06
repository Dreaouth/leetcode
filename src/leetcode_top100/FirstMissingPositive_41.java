package leetcode_top100;

//41. First Missing Positive(**)
public class FirstMissingPositive_41 {

    // 交换法：类似数组中找重复的数字
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] <= nums.length && nums[index] != (index + 1) && nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            } else {
                index++;
            }
        }
        index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
            index++;
        }
        return index + 1;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive_41 offer = new FirstMissingPositive_41();
        int[] nums = {1,1};
        int res = offer.firstMissingPositive(nums);
        System.out.println(res);
    }
}
