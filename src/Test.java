import java.util.ArrayList;
import java.util.List;

public class Test {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res + 1;
    }


    public static void main(String[] args) {
        Test offer = new Test();
        int []nums = {0,1,0,3,2,3};
        int res = offer.lengthOfLIS(nums);
        System.out.println(res);
    }

}
