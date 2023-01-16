package offer;

public class Offer_13_Robot {
    /** 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    int visited[][];
    int result = 0;
    public int movingCount(int m, int n, int k) {
        visited = new int[m][n];
        recur(0, 0, k);
        return result;
    }

    // Position (i, j)
    public void recur(int i, int j, int k) {
        if (i >= visited.length || j >= visited[0].length) {
            return;
        }
        if (visited[i][j] > 0) {
            return;
        }
        if (numPosSum(i) + numPosSum(j) > k) {
            return;
        }
        visited[i][j] = 1;
        result++;
        recur(i, j+1, k);
        recur(i+1, j, k);
    }

    public  int numPosSum(int m) {
        int s = 0;
        while (m > 0) {
            s += m % 10;
            m = m / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        Offer_13_Robot offer = new Offer_13_Robot();
        System.out.println(offer.numPosSum(0));
        System.out.println(offer.movingCount(3, 1, 0));
    }
}
