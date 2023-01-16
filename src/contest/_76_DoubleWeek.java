package contest;

public class _76_DoubleWeek {
}
class ATM {

    int[] deposit;
    int[] money = {20, 50, 100, 200, 500};
    public ATM() {
    }

    public void deposit(int[] banknotesCount) {
        deposit = banknotesCount;
    }

    public int[] withdraw(int amount) {
        int[] ret = new int[5];
        if (deposit == null){
            return new int[]{-1};
        } else {
            int remain = amount;
            for (int i = 4; i > -1 ; i--) {
                if (deposit[i] > 0) {
                    ret[i] = remain / money[i];
                    remain = remain % money[i];
                }
            }
        }
        return new int[]{};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
