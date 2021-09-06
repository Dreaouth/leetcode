package offer;

import java.util.ArrayList;

// 孩子们中的游戏（圆圈中最后剩下的数、约瑟夫环）
public class Offer46 {

    // 约瑟夫环问题：两种方法，方法一：模拟法，方法二：通过规律进行逆推
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;    // 不要忘记 -1
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        Offer46 offer46 = new Offer46();
        int last = offer46.LastRemaining_Solution(5, 3);
        System.out.println(last);
    }
}
