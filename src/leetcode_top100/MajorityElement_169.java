package leetcode_top100;

public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        int mode = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) mode = nums[i];
            if (nums[i] != mode) {
                sum += 1;
            }
            else {
                sum -= 1;
            }
        }
        sum = 0;
        for (int a : nums) {
            if (a == mode) {
                sum++;
            }
        }
        if (sum <= nums.length / 2) {
            mode = 0;
        }
        return mode;
    }

    public static void main(String[] args) {
        MajorityElement_169 offer = new MajorityElement_169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println();
    }
}
