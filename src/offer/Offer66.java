package offer;

// 机器人的运动范围
public class Offer66 {

    int sum = 0;

    public int movingCount(int rows, int cols, int threshold) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        Boolean[][] flag = new Boolean[rows][cols];
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j] = false;
            }
        }
        dfs(0,0, rows, cols, threshold, flag);
        return sum;
    }

    public void dfs(int i, int j, int rows, int cols, int threshold, Boolean[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] || (getNum(i) + getNum(j) > threshold)) {
            return;
        }
        flag[i][j] = true;
        sum += 1;
        dfs(i - 1, j, rows, cols, threshold, flag);
        dfs(i + 1, j, rows, cols, threshold, flag);
        dfs(i, j - 1, rows, cols, threshold, flag);
        dfs(i, j + 1, rows, cols, threshold, flag);
    }

    public int getNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Offer66 offer66 = new Offer66();
        int res = offer66.movingCount(0, 3, 1);
        System.out.println(res);
    }
}
