package leetcode_top100;

// 309. Best Time to Buy and Sell Stock with Cooldown(***)（状态机）
public class BestTimeToBuyAndSellStockWithCooldown_309 {

    /* 状态机转化：买入->卖出->冷冻->买入...
    3个状态用3个dp数组， hold的结果决定是否买入，rest的结果决定是否卖出
    hold[i] = max(hold[i - 1], rest[i-1]-prices[i])
    sold[i] = hold[i-1] + prices[i]
    rest[i] = max(rest[i - 1], sold[i - 1])
    Init : rest[0] = sold[0] = 0, hold[0] = Integer.MIN_VALUE
    Time : O(n)
    Space: O(n) -> O(1)
    */
    public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, rest - prices[i]);
            int temp = sold;
            sold = hold + prices[i];
            rest = Math.max(rest, temp);
        }
        return Math.max(rest, sold);
    }

    public static void main(String[] args) {

    }
}
