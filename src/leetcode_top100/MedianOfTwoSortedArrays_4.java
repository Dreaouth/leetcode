package leetcode_top100;

// 4. Median of Two Sorted Arrays(**)
public class MedianOfTwoSortedArrays_4 {

    // 二分法
    // 两个数组都用一条分割线隔开，分割线左边的所有元素数值都小于分割线右边的所有元素数值
    // 即：nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            int i = (left + right + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 0) {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }

    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 != 0) {
            int k = (length + 1) / 2;
            double res = getKthElement(nums1, nums2, k);
            return res;
        } else {
            int k1 = length / 2, k2 = length / 2 + 1;
            double res = (getKthElement(nums1, nums2, k1) + getKthElement(nums1, nums2, k2)) / 2.0;
            return res;
        }
    }

    // 通过随时改变k来计算中位数
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(index1 + k / 2, length1) - 1;
            int newIndex2 = Math.min(index2 + k / 2, length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 medianOfTwoSortedArrays_4 = new MedianOfTwoSortedArrays_4();
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(medianOfTwoSortedArrays_4.findMedianSortedArrays_2(nums1, nums2));
    }
}
