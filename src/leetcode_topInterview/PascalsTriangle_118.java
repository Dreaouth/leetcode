package leetcode_topInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            for (int j = 1; j < i; j++) {
                tempList.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            if (i > 0) tempList.add(1);
            res.add(tempList);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 offer = new PascalsTriangle_118();
        List<List<Integer>> res = offer.generate(1);
        System.out.println(res);
    }
}
