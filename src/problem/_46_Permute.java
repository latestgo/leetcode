package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permute {

    public static void main(String[] args) {
        List<List<Integer>> permute = new _46_Permute().permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, nums, path, visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
