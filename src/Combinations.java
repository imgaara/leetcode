import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/8/20 0020.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        WorkBuff buff = new WorkBuff();
        combine_(1, n, k, 0, buff, result);
        return result;
    }

    private void combine_(int start, int n, int k, int count, WorkBuff buff, List<List<Integer>> result) {
        if (count == k) {
            result.add(new ArrayList<Integer>(buff.data));
            return;
        }

        for (int i = start; i <= n; ++i) {
            buff.data.add(i);
            combine_(i + 1, n, k, count+1, buff, result);
            buff.data.remove(buff.data.size() - 1);
        }
    }

    static class WorkBuff {
        List<Integer> data = new ArrayList<Integer>();
    }
}
