package offer;

import java.util.*;
import java.util.stream.Collectors;

public class Offer_38_Permutation {

    public String[] permutation(String s) {
        List<List<Character>> res = new ArrayList<>();
        int length = s.length();
        List<Character> path = new ArrayList<>();
        boolean[] visited = new boolean[length];
        dfs(res, length, s.toCharArray(), visited, path);
        return res.stream().map(chars -> {
            String collect = chars.stream().map(String::valueOf).collect(Collectors.joining());
            return collect;
        }).toArray(String[]::new);
    }

    private void dfs(List<List<Character>> res, int length, char[] chars, boolean[] visited, List<Character> path) {
        if (path.size() == length) {
            res.add(new ArrayList<>(path));
        }
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (used.contains(chars[i]) || visited[i]) {
                continue;
            }
            used.add(chars[i]);
            path.add(chars[i]);
            visited[i] = true;
            dfs(res, length, chars, visited, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        Offer_38_Permutation offer = new Offer_38_Permutation();
        System.out.println(Arrays.toString(offer.permutation("abb")));
    }
}
