package leetcode_string;

public class LongestRepeatingCharacterReplacement_424 {

    public int characterReplacement(String s, int k) {
        if (s.length() < 2) {
            return 2;
        }
        int res = 0;
        int left = 0, right = 0;
        int []map = new int[26];
        char []str = s.toCharArray();
        int maxFrep = 0;
        while(right < s.length()) {
            map[str[right] - 'A']++;
            maxFrep = Math.max(maxFrep, map[str[right] - 'A']);

            if (right - left + 1 > maxFrep + k) {
                map[str[left] - 'A']--;
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement_424 offer = new LongestRepeatingCharacterReplacement_424();
        int res = offer.characterReplacement("AABABBA", 1);
        System.out.println(res);
    }
}
