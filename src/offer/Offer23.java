package offer;

import java.util.Arrays;

// 二叉搜索树的后序遍历序列
public class Offer23 {
    // 根据序列来看
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return false;
        }
        int index = 0;
        while (index < postorder.length-1) {
            if (postorder[index] > postorder[postorder.length - 1]){
                break;
            }
            index++;
        }
        System.out.println(index);
        for (int i = index; i < (postorder.length-1); i++) {
            if (postorder[i] < postorder[postorder.length - 1]) {
                return false;
            }
        }
        boolean left = true;
        boolean right = true;
        if (index > 0) {
            left = verifyPostorder(Arrays.copyOfRange(postorder, 0, index));
        }
        if (postorder.length - 1 - index > 0) {
            right = verifyPostorder(Arrays.copyOfRange(postorder, index, postorder.length - 1));
        }
        return (left && right);
    }

    public static void main(String[] args) {
        Offer23 offer23 = new Offer23();
        int[] fal = {1,6,3,2,5};
        int[] tru = {1,3,2,6,5};
        System.out.println(offer23.verifyPostorder(fal));
    }
}
