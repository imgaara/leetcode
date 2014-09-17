import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2014/8/31 0031.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> used = new HashSet<Integer>();
        for (int cur : num) {
            used.add(cur);
        }

        int max = 0;
        for (int cur : num) {
            if (!used.contains(cur)) {
                continue;
            }

            int len = 1;
            used.remove(cur);
            for (int i = cur - 1; used.contains(i); --i) {
                len++;
                used.remove(i);
            }

            for (int j = cur + 1; used.contains(j); ++j) {
                len++;
                used.remove(j);
            }

            if (len > max) {
                max = len;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Longest_Consecutive_Sequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }


}
