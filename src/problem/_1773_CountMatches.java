package problem;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class _1773_CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int ret = 0;
        for (List<String> list :items){
            ret += Objects.equals(list.get(map.get(ruleKey)), ruleValue) ? 1 : 0;
        }
        return ret;
    }
}
