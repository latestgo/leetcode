package offer;

public class Offer_53_Times {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        boolean flag = false;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                flag = true;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (flag) {
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                if (mid - i > -1 && nums[mid - i] == target) {
                    res++;
                }
                if (mid + i < nums.length && nums[mid + i] == target) {
                    res++;
                }
            }
            return res;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Offer_53_Times offer = new Offer_53_Times();
        int i = offer.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(i);
    }
}
