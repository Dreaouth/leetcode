package leetcode_top100;

public class SingleNumberIII_260 {

    public int[] singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        k &= -k;
        int[] res = {0, 0};
        for (int num : nums) {
            if ((k & num) == 0) {
                res[0] ^= num;
            } else
                res[1] ^= num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
