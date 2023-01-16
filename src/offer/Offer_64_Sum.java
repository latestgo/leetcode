package offer;

public class Offer_64_Sum {
    /** 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 */
    int res = 0;
     public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 1;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        Offer_64_Sum offer = new Offer_64_Sum();
        int i = offer.sumNums(9);
        System.out.println(i);
    }
}
