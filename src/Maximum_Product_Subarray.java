/**
 * Created by Administrator on 2014/12/8 0008.
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int minus = 0;
        int posti = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; ++i) {
            final int cur = A[i];
            if (cur == 0) {
                minus = 0;
                posti = 1;
                max = Math.max(max, 0);
            } else if (cur > 0) {
                posti *= cur;
                if (minus != 0) {
                    minus *= cur;
                }
                max = Math.max(max, posti);
            } else {
                if (minus == 0) {
                    minus = cur * posti;
                    posti = 1;
                    max = Math.max(max, minus);
                } else {
                    int temp = posti;
                    posti = minus * cur;
                    minus = temp * cur;
                    max = Math.max(max, posti);
                }
            }
        }

        return max;
    }
}
