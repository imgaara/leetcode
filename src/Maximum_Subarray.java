/**
 * Created by Administrator on 2014/8/24 0024.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if (sum < 0) {
                sum = A[i];
            } else {
                sum = sum + A[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
