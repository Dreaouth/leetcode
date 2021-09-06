package offer;

//数组中逆序对（**）
public class Offer35 {
    public int InversePairs(int [] array) {
        if (array.length < 2) {
            return 0;
        }
        int[] temp = new int[array.length];
        return merge(array, 0, array.length - 1, temp);
    }

    int merge(int []arr, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = merge(arr, start, mid, temp) + merge(arr, mid+1, end, temp);
        int i = start, j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
                count = count % 1000000007;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (k = start; k <= end ; k++) {
            arr[k] = temp[k];
        }
        return count;
    }
}
