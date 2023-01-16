package offer;

public class Offer_39_MajorityElement {

    public int majorityElement(int[] nums) {
        int win = nums[0];
        int tickets = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == win) {
                tickets++;
            } else {
                tickets--;
                if (tickets == 0) {
                    tickets = 1;
                    win = nums[i];
                }
            }
        }
        return win;
    }
}
