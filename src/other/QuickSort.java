package other;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int p = arr[left];
        while (left < right) {
            while (arr[right] >= p && left < right) right--;
            arr[left] = arr[right];
            while (arr[left] <= p && left < right) left++;
            arr[right] = arr[left];
        }
        arr[left] = p;
        return left;
    }
}
