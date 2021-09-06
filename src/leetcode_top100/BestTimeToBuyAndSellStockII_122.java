package leetcode_top100;

public class BestTimeToBuyAndSellStockII_122 {

    // 类似贪心法，寻找局部最小值和局部最大值，即在每个局部最小和最大区间都进行买卖
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int buy = prices[0], sell = prices[0];
        int index = 0;
        while (index < prices.length) {
            while (index < prices.length - 1 && prices[index + 1] <= prices[index]) index++;
            buy = prices[index++];
            while (index < prices.length - 1 && prices[index + 1] >= prices[index]) index++;
            if (index > prices.length - 1) {
                break;
            }
            sell = prices[index];
            max += (sell - buy);
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII_122 offer = new BestTimeToBuyAndSellStockII_122();
        int[] prices = {7,6,4,3,1};
        int res = offer.maxProfit(prices);
        System.out.println(res);
    }
}
