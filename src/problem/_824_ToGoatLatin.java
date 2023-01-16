package problem;

import java.util.List;
import java.util.Locale;

public class _824_ToGoatLatin {
    public String toGoatLatin(String sentence) {
        List<Character> list = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder ma = new StringBuilder("maa");
        for (String str : strings) {
            if (list.contains(str.charAt(0))) {
                sb.append(str);
            } else {
                sb.append(str.substring(1)).append(str.charAt(0));
            }
            sb.append(ma).append(" ");
            ma.append('a');
        }
        return sb.toString().trim();
    }
}
