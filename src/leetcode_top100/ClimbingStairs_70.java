package leetcode_top100;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        int n3;
        while (n-- >= 2) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }

    public static void main(String[] args) {
        ClimbingStairs_70 offer = new ClimbingStairs_70();
        int res = offer.climbStairs(4);
        System.out.println(res);
    }
}
