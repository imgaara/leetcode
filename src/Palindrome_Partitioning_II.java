import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Palindrome_Partitioning_II {
    static class Helper {
        int min;
    }

    public int minCut(String s) {
        Helper minCut = new Helper();
        minCut.min = Integer.MAX_VALUE;
        List<String> cur = new ArrayList<String>();
        partition_(s, 0, s.length(), cur, minCut);
        return minCut.min;
    }

    private void partition_(String s, int start, int end, List<String> cur, Helper minCut)
    {
        if (start >= end)
        {
            if (cur.size() < minCut.min) {
                minCut.min = cur.size();
            }
            return;
        }

        for (int i = start + 1; i <= end; ++i)
        {
            String pali = isPalindrome(s, start, i);
            if (null == pali)
            {
                continue;
            }
            else
            {
                cur.add(pali);
                partition_(s, i, end, cur, minCut);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private String isPalindrome(String s, int start, int end)
    {
        for (int i = start, j = end - 1; i < j; ++i, --j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return null;
            }
        }

        return s.substring(start, end);
    }
}
