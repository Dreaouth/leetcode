package leetcode_top100;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        // max指最远能到达的index
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max < i) return false;
            max = Math.max(max, nums[i] + i);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame_55 offer = new JumpGame_55();
        int[] nums = {1,1,0,1,4};
        boolean res = offer.canJump(nums);
        System.out.println(res);
    }
}
