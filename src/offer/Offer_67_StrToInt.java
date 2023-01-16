package offer;

public class Offer_67_StrToInt {
    public int strToInt(String str) {
        char[] arr = str.toCharArray();
        boolean isNeg = false;
        boolean startNum = false;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!startNum) {
                if (arr[i] == ' ') {
                    continue;
                } else if (arr[i] == '+') {
                    startNum = true;
                    continue;
                } else if (arr[i] == '-') {
                    startNum = true;
                    isNeg = true;
                    continue;
                } else if (arr[i] >= '0' && arr[i] <= '9') {
                    startNum = true;
                } else {
                    break;
                }
            }
            if (arr[i] >= '0' && arr[i] <= '9') {
                int x = Integer.parseInt(String.valueOf(arr[i]));
                if (res > 214748364 || res == 214748364 && x > 7) {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + x;
            } else {
                break;
            }

        }
        return isNeg ? -res : res;
    }

    public static void main(String[] args) {
        Offer_67_StrToInt off = new Offer_67_StrToInt();
        int i = off.strToInt("2147483648");
        System.out.println(i);
    }
}
