import java.util.*;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class _3Sum {
    public List<List<Integer>> threeSum(int[] num) {
        final int n = num.length;
        Arrays.sort(num);
        Set<List<Integer>> ret = new HashSet<List<Integer>>();

        for (int k = 0; k < n - 2; ++k) {
            int i = k + 1;
            int j = n - 1;
            while (i < j) {
                int s = num[i] + num[k] + num[j];
                if (s > 0) {
                    j--;
                } else if (s < 0) {
                    i++;
                } else {
                    ret.add(Arrays.asList(num[k], num[i], num[j]));
                    i++;
                    j--;
                }
            }
        }

        return new ArrayList<List<Integer>>(ret);
    }

    public static void main(String[] args) {
        System.out.println(new _3Sum().threeSum(new int[]{0,0,0,0}));
    }
}
