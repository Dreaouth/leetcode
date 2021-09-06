package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22, 1009 };
        int k = 0;
        ArrayList<Integer> res = topK(arr, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 找出arr中最大的k个数字
    private static ArrayList<Integer> topK(int[] arr, int k) {
        if (k <= 0) {
            return new ArrayList<>();
        }
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 最大堆用o2 - o1，最小堆用o1 - o2
                return o2 - o1;
            }
        });
        if (arr.length >= k) {
            for (int i = 0; i < k; i++) {
                queue.add(arr[i]);
            }
        }
        else {
            System.out.println("Error, the number is less than k");
            return new ArrayList<>();
        }
        for (int i = k; i < arr.length; i++) {
            int temp = queue.peek();
            if (arr[i] < temp) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }


}
