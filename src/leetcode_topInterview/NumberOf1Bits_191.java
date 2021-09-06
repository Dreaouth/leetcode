package leetcode_topInterview;

public class NumberOf1Bits_191 {

    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) res++;
            mask = mask << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1Bits_191 offer = new NumberOf1Bits_191();
        int res = offer.hammingWeight(3);
        System.out.println(res);
    }

}
