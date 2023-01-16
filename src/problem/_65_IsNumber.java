package problem;

public class _65_IsNumber {
    public boolean isNumber(String s) {
        String[] arr = s.trim()
                        .split("[eE]", 2);
        if (s.contains("e") || s.contains("E")) {
            if (arr.length == 2) {
                String arr1 = arr[1];
                if (arr1.isBlank()) {
                    return false;
                }
                if (arr[1].startsWith("-") || arr[1].startsWith("+")) {
                    arr1 = arr1.substring(1);
                    if (arr1.isBlank()) {
                        return false;
                    }
                }
                if (!checkNumber(arr1)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        String arr0 = arr[0].trim();
        if (arr0.isBlank()) {
            return false;
        }
        if (arr0.startsWith("-") || arr0.startsWith("+")) {
            arr0 = arr0.substring(1);
            if (arr0.isBlank()) {
                return false;
            }
        }
        if (arr0.contains(".")) {
            if (arr0.startsWith(".")) {
                arr0 = arr0.substring(1);
                if (arr0.isBlank()) {
                    return false;
                }
                return checkNumber(arr0);
            } else if (arr0.endsWith(".")) {
                arr0 = arr0.substring(0, arr0.length() - 1);
                if (arr0.isBlank()) {
                    return false;
                }
                return checkNumber(arr0);

            } else {
                String[] preArr = arr0.split("\\.", 2);
                if (preArr.length == 2) {
                    if (preArr[0].isBlank() && preArr[1].isBlank()) {
                        return false;
                    }
                    if (!checkNumber(preArr[0]) || !checkNumber(preArr[1])) {
                        return false;
                    }
                } else {
                    return false;
                }
                return checkNumber(preArr[0]);
            }
        } else {
            return checkNumber(arr0);
        }
    }

    private boolean checkNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new _65_IsNumber().checkNumber("e");
    }
}
