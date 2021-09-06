package leetcode_top100;

//45. Jump Game II(**)
public class JumpGameII_45 {

    // 依然是贪心法：因为每次更新的max最远距离是一步一步积累出来的，所以只需要一个max即可
    public int jump(int[] nums) {
        int max = 0, jump = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            // 相当于贪心发，因为步数都是积累出来的，所以默认跳当前可以跳的最大的一步
            if (i == end) {
                jump++;
                end = max;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGameII_45 offer = new JumpGameII_45();
        int[] nums = {2,3,0,1,4};
        int res = offer.jump(nums);
        System.out.println(res);
    }
}
