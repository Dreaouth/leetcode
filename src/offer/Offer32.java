package offer;

//把数组排成最小的数
public class Offer32 {

    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i; j < strs.length; j++) {
                if ((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) >= 0) {
                    String temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Offer32 offer32 = new Offer32();
        int[] nums = {3, 32, 321};
        String res = offer32.PrintMinNumber(nums);
        System.out.println(res);
    }
}
