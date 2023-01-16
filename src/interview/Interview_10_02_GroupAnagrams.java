package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Interview_10_02_GroupAnagrams {
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = String.valueOf(array);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Interview_10_02_GroupAnagrams c = new Interview_10_02_GroupAnagrams();
        List<List<String>> lists = c.groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
