package contest;

import util.TreeNode;

public class _292_Week {
    public String largestGoodInteger(String num) {
        String ret = "";
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i - 2) == num.charAt(i) && num.charAt(i - 1) == num.charAt(i)) {
                String tmp = num.substring(i - 2, i + 1);
                if (ret.isEmpty() || ret.charAt(0) < tmp.charAt(0)) {
                    ret = tmp;
                }
            }
        }
        return ret;
    }

    int ret = 0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return ret;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        int sum = left[0] + right[0] + root.val;
        int num = left[1] + right[1] + 1;
        if (root.val == sum / num) {
            ret++;
        }
        return new int[]{sum, num};
    }

    public int countTexts(String pressedKeys) {
        return 1;
    }

    /**
     * 2        1 a
     * 22       2 aa b
     * 222      4 aaa ab ba c
     * 2222     4 * 1 + 1 aaaa aba baa ca a
     * 22222    4 * 2 + 1 aaaaa aaab abaa abb baaa bab caa cb b
     * 222222   4 * 4 + 1
     *
     * 7 p
     * 77 pp q
     * 777 ppp pq qp r
     * 7777 pppp ppq qpp pr rp s
     * 77777
     * @param key
     * @return
     */
    private int count(String key) {
        if (key.length() <= 2) {
            return key.length();
        }
        if (key.length() == 3) {
            return 4;
        }
        return 0;
    }

    public boolean hasValidPath(char[][] grid) {
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int count, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return count == 0;
        }
        boolean xr = false;
        if (x + 1 < grid.length) {
            xr = dfs(grid, grid[x][y] == '(' ? count + 1 : count - 1, x + 1, y);
        }
        boolean yr = false;
        if (y + 1 < grid[0].length) {
            yr = dfs(grid, grid[x][y] == '(' ? count + 1 : count - 1, x , y + 1);
        }
        return xr || yr;
    }
}
