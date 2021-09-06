import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while (t-- > 0) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int c = scanner.nextInt();
//            int total = 0;
//            for (int i = 0; i < 31; i++) {
//                int a_1 = (a >> i) & 1;
//                int b_1 = (b >> i) & 1;
//                int c_1 = (c >> i) & 1;
//                if (c_1 == 0) {
//                    total += a_1 + b_1;
//                } else {
//                    total += (a_1 + b_1 == 0 ? 1 : 0);
//                }
//            }
//            System.out.println(total);
//        }


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double total = 0;
        if (n < 2) {
            System.out.println("1.0000");
            return;
        }
        for (int i = 1; i < n; i++) {
            int start = i, last = n - i;
            if (start < last) {
                int temp = start;
                start = last;
                last = temp;
            }
            if (start - last < 2) {
                total = total + start;
            } else {
                int cc = start - last;
                int t = cc / 2;
                double res;
                if (cc % 2 == 0) res = (double)(t *t * 3 - 2 * t)/(2*t - 1.0);
                else res = (double) (t * 3 + 1)/2;
                total = total + last + res;
            }
        }
        System.out.printf("%.4f%n", total/(n - 1));

        String str = "sss";
    }
}
