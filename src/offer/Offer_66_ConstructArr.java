package offer;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中
 * B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Offer_66_ConstructArr {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        Arrays.fill(b, 1);
        int[] lTimes = new int[a.length], rTimes = new int[a.length];
        Arrays.fill(lTimes, 1);
        Arrays.fill(rTimes, 1);
        int lt = 1, rt = 1;
        for (int i = 0; i < a.length; i++) {
            lTimes[i] = lt;
            rTimes[a.length - i - 1] = rt;
            lt *= a[i];
            rt *= a[a.length - i - 1];
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = lTimes[i] * rTimes[i];
        }
        return b;
    }

    public static void main(String[] args) {
        Offer_66_ConstructArr offer = new Offer_66_ConstructArr();
        int[] ints = offer.constructArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(ints));
    }
}
