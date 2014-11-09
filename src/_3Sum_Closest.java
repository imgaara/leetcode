import java.util.*;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class _3Sum_Closest {
    public int threeSumClosest(int[] num, int target) {
        final int n = num.length;
        Arrays.sort(num);

        int ret = target;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n - 2; ++k) {
            int i = k + 1;
            int j = n - 1;
            while (i < j) {
                int s = num[i] + num[k] + num[j];
                int abs = Math.abs(s - target);
                if (abs < min) {
                    min  = abs;
                    ret = s;
                }

                if (s > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _3Sum_Closest().threeSumClosest(new int[] {0,1,2}, 3));
    }


}
