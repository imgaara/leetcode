import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Palindrome_Partitioning {

    public List<List<String>> partition(String s)
    {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        partition_(s, 0, s.length(), cur, results);
        return results;
    }

    private void partition_(String s, int start, int end, List<String> cur, List<List<String>> results)
    {
        if (start >= end)
        {
            results.add(new ArrayList<String>(cur));
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
                partition_(s, i, end, cur, results);
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Palindrome_Partitioning().partition("cbbbcc"));
        System.out.println(System.currentTimeMillis() - start);
    }
}
