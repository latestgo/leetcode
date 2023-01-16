package offer;

import java.util.Arrays;

public class Offer_40_Min {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        int resMax = Integer.MIN_VALUE;
        int resPos = -1;
        for (int i = 0; i < arr.length; i++) {
           if (i < k)  {
               res[i] = arr[i];
               if (resMax < arr[i]) {
                   resMax = arr[i];
                   resPos = i;
               }
           } else {
               if (resMax > arr[i]) {
                   // 发现更小值，重新选择出最大值及其索引
                   res[resPos] = arr[i];
                   resMax = arr[i];
                   for (int j = 0; j < res.length; j++) {
                       if (res[j] > resMax) {
                           resMax = res[j];
                           resPos = j;
                       }
                   }
               }
           }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer_40_Min offer = new Offer_40_Min();
        int[] ints = offer.getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
