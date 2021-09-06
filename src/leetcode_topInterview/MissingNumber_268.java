package leetcode_topInterview;

public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }
        System.out.println(xor);
        return xor ^ nums.length;
    }

    public static void main(String[] args) {
        MissingNumber_268 offer = new MissingNumber_268();
        int[] nums = {3,0,1};
        int res = offer.missingNumber(nums);
        System.out.println(res);
    }

}
