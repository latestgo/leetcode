package problem;

public class _414_ThirdMax {
    public int thirdMax(int[] nums) {
        int ia = -1, ib = -1, ic = -1;
        for (int i = 0; i < nums.length; i++) {
            if (ia < 0 || nums[i] > nums[ia]) {
                ic = ib;
                ib = ia;
                ia = i;
            } else if ((ib < 0 || nums[i] > nums[ib]) && nums[i] < nums[ia]) {
                ic = ib;
                ib = i;
            } else if ((ic < 0 || nums[i] > nums[ic]) && ib >=0 && nums[i] < nums[ib]) {
                ic = i;
            }
        }
        return ic < 0 ? nums[ia] : nums[ic];
    }
}
