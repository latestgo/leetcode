package hot100;

import java.util.ArrayList;
import java.util.List;

public class _41_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        permute(nums, new boolean[nums.length], 0, new ArrayList<>(), resultList);
        return resultList;
    }

    void permute(int[] nums, boolean[] visited, int d, List<Integer> result, List<List<Integer>> resultList) {
        if (d == visited.length) {
            resultList.add(new ArrayList<>(result));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(nums[i]);
                permute(nums, visited, d + 1, result, resultList);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new _41_Permute().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
