package tencent;

import java.util.Scanner;

public class Test2020_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int total = (int) Math.pow(m, n);
        int notConF = (int) Math.pow(m - 1, n - 1) * m;
        int res = total - notConF;
        System.out.println(res);
    }
}
