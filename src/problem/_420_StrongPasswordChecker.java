package problem;

public class _420_StrongPasswordChecker {
    public int strongPasswordChecker(String password) {
        // 统计重复3个及以上的
        int len = password.length();
        int dupToChange = 0; // 重复替换的次数
        int dupTmpTime = 1;
        int bigAlphaCount = 1, alphaCount = 1, numberCount = 1;
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            // 检查
            if (i > 0) {
                if (password.charAt(i) == password.charAt(i - 1)) {
                    dupTmpTime++;
                } else {
                    dupToChange += dupTmpTime / 3;
                    dupTmpTime = 1;
                }
            }
            if (i == len - 1) {
                dupToChange +=dupTmpTime / 3;
            }

            // 统计字母和数字个数
            if (numberCount > 0 && c >= '0' && c <= '9') {
                numberCount--;
            } else if (alphaCount > 0 && c >= 'a' && c <= 'z')
                alphaCount--;
            else if (bigAlphaCount > 0 && c >= 'A' && c <= 'Z')
                bigAlphaCount--;
        }
        int count = bigAlphaCount + alphaCount + numberCount;
        if (len < 6) {
//            int v = 6 - len + dupToChange;
            return Math.max(6 - len, Math.max(dupToChange, count));
        } else if(len > 20) {
//            int v = len - 20 + count;
            return Math.max(len - 20, Math.max(count, dupToChange));
        } else {
            return Math.max(count, dupToChange);
        }
    }

    public static void main(String[] args) {
        new _420_StrongPasswordChecker().strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc");
    }
}
