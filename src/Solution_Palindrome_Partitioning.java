import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @file Solution_Palindrome_Partitioning.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-7
 * 
 * 
 */
public class Solution_Palindrome_Partitioning
{
    static final int MAX = 10000;
    private boolean[][] palindromeMap = new boolean[MAX][MAX];
    
    public Solution_Palindrome_Partitioning() {
        for (int i = 0; i < 10000; ++i) {
            palindromeMap[i] = new boolean[MAX];
        }
    }

    public List<List<String>> partition(String s)
    {
        return partition_(s, 0, s.length());
    }

    private List<List<String>> partition_(String s, int start, int end)
    {
        if (start + 1 == end)
        {
            List<List<String>> result = new LinkedList<List<String>>();
            List<String> oneResult = new LinkedList<String>();
            oneResult.add(s.substring(start, end));
            result.add(oneResult);
            return result;
        }

        List<List<String>> results = new LinkedList<List<String>>();
        for (int i = start + 1; i <= end; ++i)
        {
            String pali = isPalindrome(s, start, i);
            if (null == pali)
            {
                continue;
            }
            else
            {
                if (i < end) {
                    List<List<String>> sub = partition_(s, i, end);
                    for (List<String> oneResult : sub)
                    {
                        oneResult.add(0, pali);
                        results.add(oneResult);
                    }
                }
            }
        }
        
        return results;
    }

    private String isPalindrome(String s, int start, int end)
    {
        if (palindromeMap[start][end]) { return s.substring(start, end); }

        for (int i = start, j = end - 1; i <= j; ++i, --j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                palindromeMap[start][end] = false;
                return null;
            }
        }

        palindromeMap[start][end] = true;
        return s.substring(start, end);
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Palindrome_Partitioning().partition("cdd"));
    }
}
