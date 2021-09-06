package offer;

import java.util.ArrayList;

// 和为S的连续正数序列
public class Offer41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int tmpSum = 1;
        int left = 1, right = 1;
        ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
        while (left < (sum/2 + 1) && right < sum) {
            System.out.println("left = " + left + " right = " + right);
            if (tmpSum < sum) {
                right++;
                tmpSum += right;
            } else if (tmpSum > sum) {
                tmpSum -= left;
                left++;
            } else {
                System.out.println("Got a equal");
                ArrayList<Integer> seq = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    seq.add(i);
                }
                sequence.add(seq);
                tmpSum -= left;
                left++;
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        int sum = 3;
        Offer41 offer41 = new Offer41();
        ArrayList<ArrayList<Integer>> sequence = offer41.FindContinuousSequence(sum);
        for (ArrayList<Integer> arrayList : sequence) {
            for (int tmp : arrayList) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }
}
