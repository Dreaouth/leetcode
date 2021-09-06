package leetcode_top100;

public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minLeft = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minLeft) {
                minLeft = prices[i];
            }
            max = Math.max(max, prices[i] - minLeft);
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 offer = new BestTimeToBuyAndSellStock_121();
        int[] nums = {7,6,4,3,1};
        int res = offer.maxProfit(nums);
        System.out.println(res);
    }
}
