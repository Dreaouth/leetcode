package tencent;

import java.util.Scanner;

public class Test2020_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] blood = new int[n];
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            blood[i] = scanner.nextInt();
            money[i] = scanner.nextInt();
        }
        int tempLife = 0;
        for (int i = 0; i < blood.length; i++) {
            if (money[i] * q - blood[i] > 0) {
                tempLife = tempLife + money[i] * q - blood[i];
            }
        }
        System.out.println(tempLife / q);
    }
}
