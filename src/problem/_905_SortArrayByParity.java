package problem;

public class _905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                i++;
            }
            if (nums[j] % 2 != 0) {
                j--;
            }
            if (i < j && nums[i] %2 != 0 && nums[j] % 2 == 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        new _905_SortArrayByParity().sortArrayByParity(new int[]{ 1, 3, 2, 4});
    }
}
