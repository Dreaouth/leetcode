package alibaba;

import java.util.Scanner;

public class Test3_6_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t -- > 0) {
            int num = scanner.nextInt();
            long n = 6;
            long m = 6;
            for (int i = 0; i < num - 1; i++) {
                long newN = (n * 2) % 1000000007 + (m * 2) % 1000000007;
                long newM = (n * 2) % 1000000007 + (m * 3) % 1000000007;
                n = newN % 1000000007;
                m = newM % 1000000007;
            }
            System.out.println((m + n) % 1000000007);
        }
    }

}
