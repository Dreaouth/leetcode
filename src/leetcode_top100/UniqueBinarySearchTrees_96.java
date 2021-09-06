package leetcode_top100;

// Unique Binary Search Trees(**)
public class UniqueBinarySearchTrees_96 {

    // 遍历每个数字 i，将该数字作为树根，将 1⋯(i−1) 序列作为左子树，将 (i+1)⋯n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。
    // 动态规划
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 相当于以序列中每一个点为根节点，然后再将其相加
                // G[j - 1] * G[i - j]表示以i为根节点时，其左边和右边的节点为左右子树，因为G(n)和序列的内容无关，只和序列的长度有关
                // 相当于做一个自由组合，所以做一个笛卡尔积
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_96 offer = new UniqueBinarySearchTrees_96();
        int res = offer.numTrees(3);
        System.out.println(res);
    }


}
