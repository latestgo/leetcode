package problem;

import java.util.*;

public class _310_FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return findHeightTree(n, edges);
    }

    private List<Integer> findHeightTree1(int n, int[][] edges) {
        //
        if (edges.length == 0) {
            return List.of(0);
        }
        int[] deg = new int[n];
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
            List<Integer> list = neighbor.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(edges[i][1]);
            neighbor.put(edges[i][0], list);
            list = neighbor.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(edges[i][0]);
            neighbor.put(edges[i][1], list);
        }

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                q.add(i);
            }
        }

        List<Integer> list = null;
        while (!q.isEmpty()) {
            list = new ArrayList<>();

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int e = q.poll();
                list.add(e);
                deg[e]--;
                // 邻居
                List<Integer> neighbors = neighbor.get(e);
                for (int j = 0; j < neighbors.size(); j++) {
                    deg[neighbors.get(j)]--;
                    if (deg[neighbors.get(j)] == 1) {
                        q.add(neighbors.get(j));
                    }
                }
            }
        }
        return list;
    }

    private List<Integer> findHeightTree(int n, int[][] edge) {
        int min = Integer.MAX_VALUE;
        List<Integer> ret = new ArrayList<>();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            int h = heightTree(i, new int[n], edge);
            min = Math.min(min, h);
            heights[i] = h;
        }
        for (int i = 0; i < n; i++) {
            if (heights[i] == min) {
                ret.add(i);
            }
        }
        return ret;
    }

    //求一棵树的高度
    private int heightTree(int root, int[] visited, int[][] edge) {
        visited[root] = 1;

        int max = 0;
        for (int i = 0; i < edge.length; i++) {
            if (edge[i][0] == root && visited[edge[i][1]] == 0) {
                max = Math.max(max, heightTree(edge[i][1], visited, edge));
            }
            if (edge[i][1] == root && visited[edge[i][0]] == 0) {
                max = Math.max(max, heightTree(edge[i][0], visited, edge));
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
//        new _310_FindMinHeightTrees().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        new _310_FindMinHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
}
