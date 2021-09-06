package alibaba;

import template.Tree;

import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static class TreeNode {
        int val;
        Tree.TreeNode left;
        Tree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Tree.TreeNode left, Tree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] counts=new int[31]; //记录每个节点被经过的次数
        for(int i=0;i<31;i++) counts[i]=0;
        int[] vector = new int[15]; //最多四层，所以节点不超过15个
        Scanner s = new Scanner(System.in);
        int size=0;
        for(;size<15;size++){
            String str = s.next();
            if(str==null || Objects.equals(str, "") || Objects.equals(str, "0")) break;
            vector[size] = Integer.parseInt(str.trim());
        }
        for(int i=size-1;i>=0;i--){
            int index = (vector[i]%100)/10;
            int floor = vector[i]/100;
            int cntIndex = (int)Math.pow(2,floor-1)+index;//节点在完全二叉树中的下标
            if(counts[cntIndex*2]+counts[cntIndex*2-1]==0)counts[cntIndex]=1;//如果是叶子节点，经过次数为1
            else counts[cntIndex] =counts[cntIndex*2]+counts[cntIndex*2-1];//非叶子节点经过次数为其子节点经过次数之和
        }
        int sum=0;
        for(int i=0;i<size;i++){
            int value = vector[i]%10;
            int index = (vector[i]%100)/10;
            int floor = vector[i]/100;
            int cntIndex = (int)Math.pow(2,floor-1)+index;
            sum+=value*counts[cntIndex];//求和
        }
        System.out.println(sum);
    }
}
