import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        combinationSum2_(num, target, 0, cur, results);

        return results;
    }


    private void combinationSum2_(int[] num, int target, int start, List<Integer> cur, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(cur));
        }

        for (int i = start; i < num.length; ++i) {
            if (i != start && num[i] == num[i-1]) {
                continue;
            }
            int curNum = num[i];
            if (curNum <= target) {
                cur.add(curNum);
                combinationSum2_(num, target - curNum, i + 1, cur, results);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combination_Sum_II().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
