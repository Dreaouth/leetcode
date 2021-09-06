package offer;

// 第一个只出现一次的字符位置
public class Offer34 {
    public int FirstNotRepeatingChar(String str) {
        int[] hash = new int[52];
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c >= 'A' && c <= 'Z') {
                hash[c - 65] += 1;
            } else if (c >= 'a' && c <= 'z') {
                hash[c - 97 + 26] += 1;
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (hash[arr[i] - 65] == 1) {
                    return i;
                }
            } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                if (hash[arr[i] - 97 + 26] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Offer34 offer34 = new Offer34();
        String str = "google";
        int pos = offer34.FirstNotRepeatingChar(str);
        System.out.println(pos);
    }
}
