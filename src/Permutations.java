/**
 * Created by Administrator on 2014/7/26 0026.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curReuslt = new ArrayList<Integer>();
        permute_(num, 0, curReuslt, results);
        return results;
    }

    private void permute_(int[] num, int start, List<Integer> cur, List<List<Integer>> results) {
        if (start >= num.length) {
            results.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < num.length; ++i) {
            swap(num, start, i);
            cur.add(num[start]);
            permute_(num, start + 1, cur, results);
            cur.remove(cur.size() - 1);
            swap(num, start, i);
        }
    }

    private void swap(int[] num, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
