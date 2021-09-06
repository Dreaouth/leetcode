package alibaba;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 小强有n个养鸡场，弟i个养鸡场初始有a[i]只小鸡。与其他养鸡场不同的是，他的养鸡场每天增加k只小鸡，
// 小强每天结束都会在数量最多的养鸡场里卖掉一半的小鸡，假如一个养鸡场有x只鸡，则卖出后只剩下x/2(向下取整)只鸡。
// 问m天后小强的n个养鸡场一共多少只小鸡？
public class Test3_30_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        // 不需要循环增加鸡，只需要
        for (int i = 0; i < m; i++) {
            int num = queue.poll();
            num -= (num + (i + 1) * k) / 2;
            queue.add(num);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += queue.poll();
        }
        System.out.println(res + (n * m * k));
    }
}
