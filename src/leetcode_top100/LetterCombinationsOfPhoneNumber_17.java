package leetcode_top100;

import java.util.ArrayList;
import java.util.List;

// (*)
public class LetterCombinationsOfPhoneNumber_17 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(0, digits, "", phone);
        return res;
    }

    public void dfs(int index, String digits, String nums, String[] phone) {
        System.out.println(nums + " " + index);
        if (nums.length() == digits.length()) {
            res.add(nums);
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            String abs = phone[digits.charAt(i) - '0'];
            for (int j = 0; j < abs.length(); j++) {
                dfs(i + 1, digits, nums + abs.charAt(j), phone);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber_17 offer = new LetterCombinationsOfPhoneNumber_17();
        List<String> res = offer.letterCombinations("345");
        System.out.println(res);
    }
}
