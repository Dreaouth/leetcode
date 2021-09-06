package offer;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int res = 0;
        while (res < nums.length) {
            if (nums[res] == res && nums[res] == nums[nums[res]]) {
                res++;
            }
            else if (nums[res] != res && nums[res] != nums[nums[res]]) {
                swap(nums, res, nums[res]);
            }
            else {
                return nums[res];
            }
        }
        return res;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        Offer03 offer03 = new Offer03();
        int res = offer03.findRepeatNumber(nums);
        System.out.println(res);
    }
}
