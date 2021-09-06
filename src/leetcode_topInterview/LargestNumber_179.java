package leetcode_topInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber_179 {

    public String largestNumber(int[] nums) {
        String[] arrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        if (arrs[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String arr : arrs) {
            res.append(arr);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber_179 offer = new LargestNumber_179();
        int[] nums = {10,2};
        String res = offer.largestNumber(nums);
        System.out.println(res);
    }
}
