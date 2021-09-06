package leetcode_top100;

//11. Container With Most Water(*)
public class ContainerWithMostWater_11 {

    //证明目标：如果在[i，j]的子范围内有更好的答案，则范围[i + 1，j]必须包含该最佳子范围。（这并不意味着范围[i，j-1]无法包含它，我们只是想证明范围[i + 1，j]将包含它）
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater_11 offer = new ContainerWithMostWater_11();
        int[] height = {1,2,1};
        int res = offer.maxArea(height);
        System.out.println(res);
    }
}
