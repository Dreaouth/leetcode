package leetcode_top100;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight_406 {

    // 先进行排序，先确定矮个子的位置，空出的位置都是比他高的，由于先确定的矮个子，所以剩下的都比他高，也就相当于确定了
    // 空着的位置都比他高，所以根据是否空位置进行计算，再将第 i 个人放入队列中的第 ki+1 个空位置
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    // 因为身高判定是小于等于，所以需要先确定排在后面的，再确定排在前面的
                    return o2[1] - o1[1];
                }
            }
        });
        for (int i = 0; i < people.length; i++) {
            System.out.print(people[i][0] + "," + people[i][1] + " ");
        }
        System.out.println();
        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1] + 1;
            for (int j = 0; j < people.length; j++) {
                if (res[j] == null) {
                    index--;
                }
                if (index == 0) {
                    res[j] = people[i];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight_406 offer = new QueueReconstructionByHeight_406();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = offer.reconstructQueue(people);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + "," + res[i][1] + " ");
        }
        System.out.println();
    }
}
