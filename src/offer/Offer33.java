package offer;

//丑数（*）
public class Offer33 {
    //输出从小到大的第n个丑数
    public int GetUglyNumber_Solution(int index) {
        if (index == 1) {
            return 1;
        }
        int u2 = 0, u3 = 0, u5 = 0;
        int[] num = new int[index];
        num[0] = 1;
        for (int i = 1; i < index; i++) {
            num[i] = getMin(num[u2] * 2, num[u3] * 3, num[u5] * 5);
            if (num[i] == num[u2] * 2) {
                u2 += 1;
            }
            if (num[i] == num[u3] * 3) {
                u3 += 1;
            }
            if (num[i] == num[u5] * 5) {
                u5 += 1;
            }
        }
        return num[index - 1];
    }

    public int getMin(int... values){
        int min = Integer.MAX_VALUE;
        for(int d:values){
            if(d<min)min=d;
        }
        return min;
    }

    public static void main(String[] args) {
        Offer33 offer33 = new Offer33();
        int res = offer33.GetUglyNumber_Solution(10);
        System.out.println(res);
    }
}
