package offer;

// 数组中重复的数字
public class Offer50 {

    // 交换法和哈希法均可，下面是交换法
    public boolean duplicate(int nums[] ,int length ,int [] duplication) {
        duplication[0] = -1;
        if (nums.length == 0) {
            return false;
        }
        int res = 0;
        while (res < nums.length) {
            if (nums[res] == res && nums[res] == nums[nums[res]]) {
                res++;
            }
            else if (nums[res] != res && nums[res] != nums[nums[res]]) {
                swap(nums, res, nums[res]);
            }
            else {
                duplication[0] = nums[res];
                return true;
            }
        }
        return false;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();
        int[] numbers = {2,3,1,0,2,5,3};
        int[] dup = new int[1];
        boolean res = offer50.duplicate(numbers, 7, dup);
        System.out.println(res + " " + dup[0]);
    }
}
