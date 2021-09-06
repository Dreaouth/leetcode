package offer;

// 构建乘积数组
public class Offer51 {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length <= 1) {
            return A;
        }
        int temp = 1;
        B[B.length - 1] = 1;
        B[B.length - 2] = A[A.length - 1];
        for (int i = A.length-2; i > 0; i--) {
            B[i-1] = A[i] * B[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                temp = temp * A[i-1];
                B[i] = B[i] * temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        Offer51 offer51 = new Offer51();
        int[] nums = {1, 2, 3, 4, 5};
        int[] res = offer51.multiply(nums);
        for (int n :res) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
