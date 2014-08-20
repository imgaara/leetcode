import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by www.imgaara.com on 2014/8/20 0020.
 */
public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (null == num || 0 == num.length) {
            return results;
        }

        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetsWithDupDP_(num, 0, cur, results);
        return results;
    }

    public void subsetsWithDupDP_(int[] num, int start, List<Integer> cur, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(cur));

        for (int i = start; i < num.length; ++i) {
            if (i != start && num[i] == num[i-1]) {
                continue; // alreay sorted num array, here to remove duplicate result
            }

            cur.add(num[i]);
            subsetsWithDupDP_(num, i+1, cur, results);
            cur.remove(cur.size() - 1);
        }
    }
}
