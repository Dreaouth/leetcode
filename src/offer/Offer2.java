package offer;
// 替换空格
public class Offer2 {
    public static String replaceSpace(StringBuffer str) {
        int space = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                space++;
            }
        }
        int oldLength = str.length();
        int newLength = str.length() + space * 2;
        str.setLength(newLength);
        for (int i = oldLength - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(i + space*2, '0');
                str.setCharAt(i + space*2 - 1, '2');
                str.setCharAt(i + space*2 - 2, '%');
                space--;
            }
            else {
                str.setCharAt(i + space*2, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" helloworld");
        String replaced_str = replaceSpace(str);
        System.out.println(replaced_str);
    }
}
