package problem;

import java.util.HashSet;
import java.util.Set;

public class _1863_SubsetXORSum {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        int[] ints = new int[nums.length];
        recur(nums, ints, 0, 0);
        return sum;
    }

    private void recur(int[] nums, int[] visited, int orSum, int d) {
        for (int i = d; i < nums.length; i++) {
            if (visited[i] ==0) {
                int tmp = orSum ^ nums[i];
                sum += tmp;
                visited[i] = 1;
                recur(nums, visited, tmp, i);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new _1863_SubsetXORSum().subsetXORSum(new int[] {1, 3});
    }
}
