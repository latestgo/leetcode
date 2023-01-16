package problem;

public class _171_TitleToNumber {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int num = columnTitle.charAt(len - 1) -  'A' + 1;
        if (len > 1) {
            int tmp = 1;
            for (int i = 1; i < columnTitle.length(); i++) {
                int c = columnTitle.charAt(len - i - 1) - 'A' + 1;
                num += tmp * 26 * c;
                tmp *= 26;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        _171_TitleToNumber ti = new _171_TitleToNumber();
        int i = ti.titleToNumber("AA");
        System.out.println(i);
    }
}
