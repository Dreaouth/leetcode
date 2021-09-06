package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static int[] mergeSort(int[] array){
        if (array.length == 0) {
            return null;
        }
        int start = 0, end = array.length - 1;
        int[] res = new int[array.length];
        mergeSortRecursive(array, res, start, end);
        return res;
    }

    static void mergeSortRecursive(int[] arr, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        int k = start;
        mergeSortRecursive(arr, res, start1, end1);
        mergeSortRecursive(arr, res, start2, end2);
        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] < arr[start2]) {
                res[k++] = arr[start1++];
            } else {
                res[k++] = arr[start2++];
            }
        }
        while (start1 <= end1) {
            res[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            res[k++] = arr[start2++];
        }
        // <=mid
        for (k = start; k <= end ; k++){
            arr[k] = res[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        arr = mergeSort(arr);
        System.out.println("排序后:");
        ArrayList<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
    }
}
