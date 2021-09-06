package leetcode_top100;

// 75. 荷兰国旗问题（*）
public class SortColors_75 {

    // 双指针+遍历法
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                right--;
            } else if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
                index++;
            }
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        SortColors_75 offer = new SortColors_75();
        int[] nums = {2,0,1};
        offer.sortColors(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
