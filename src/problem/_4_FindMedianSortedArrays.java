package problem;

public class _4_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lastIndex = (nums1.length + nums2.length) / 2;
        int realLastIndex = lastIndex % 2 == 0 ? lastIndex + 1 : lastIndex;
        int i = 0, j = 0;
        int last = 0, cur = 0;
        while (i < nums1.length && j < nums2.length && (i+j) < realLastIndex) {
            last = cur;
            if (nums1[i] < nums1[j]) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
        }
        while (i < nums1.length && i + j < realLastIndex) {
            last = cur;
            cur = nums1[i];
            i++;
        }
        while (j < nums2.length  && i + j < realLastIndex) {
            last = cur;
            cur = nums2[j];
            j++;
        }
        if (lastIndex % 2 == 0) {
            return (last + cur) / 2.0;
        } else {
            return cur;
        }
    }
}
