package offer;

public class Offer_51_ReversePairs {
    private int ret = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    private void mergeSort(int[] nums, int i, int j) {
        int mid = ((j - i) / 2) + i;
        if (i < j) {
            mergeSort(nums, i, mid);
            mergeSort(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        int len = r - l + 1;
        int[] tmp = new int[len];
        int tmpI = 0;
        int leftI = l;
        int rightI = m + 1;
        while (leftI <= m && rightI <= r) {
            if (nums[leftI] <= nums[rightI]) {
                tmp[tmpI] = nums[leftI++];
            } else {
                tmp[tmpI] = nums[rightI++];
                ret += m - leftI + 1;
            }
            tmpI++;
        }
        while (leftI <= m) {
            tmp[tmpI++] = nums[leftI++];
        }
        while (rightI <= r) {
            tmp[tmpI++] = nums[rightI++];
        }
        System.arraycopy(tmp, 0, nums, l, len);
    }

    public int reversePairs1(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    ret ++;
                }
            }
        }
        return ret;
    }
}
