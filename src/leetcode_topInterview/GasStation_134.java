package leetcode_topInterview;

public class GasStation_134 {

    // cy好解法：折线图，找到折线图的最低点，其下一个就是开始启动的节点
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            System.out.println(spare);
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        GasStation_134 offer = new GasStation_134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int res = offer.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
