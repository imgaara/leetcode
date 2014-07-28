import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Palindrome_Partitioning_II {

    static class Helper {
        int val;
    }

    public int minCut(String s) {
        Helper helper = new Helper();
        helper.val = Integer.MAX_VALUE;
        int[] cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        partition_(s, 0, s.length(), 0, helper, cache);
        return helper.val;
    }

    private int partition_(String s, int start, int end, final int level, Helper helper, int[] cache)
    {
        if (start >= end - 1)
        {
            if (level < helper.val) {
                helper.val = level;
            }
            return 0;
        }

        if (level >= helper.val) {
            return -1;
        }

        if (cache[start] != -1) {
            int cur = level + cache[start];
            if (cur < helper.val) {
                helper.val = cur;
            }
            return cache[start];
        }

        int min = Integer.MAX_VALUE;
        for (int i = end; i >= start+1; i--)
        {
            if (!isPalindrome(s, start, i))
            {
                continue;
            }
            else
            {
                if (i == end) {
                    if (level < helper.val) {
                        helper.val = level;
                    }
                    cache[start] = 0;
                    return 0;
                } else {
                    int cur = partition_(s, i, end, level + 1, helper, cache);
                    if (cur != -1) {
                        cache[i] = cur;
                        if (cur < min) {
                            min = cur;
                        }
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : 1 + min;
    }

    private boolean isPalindrome(String s, int start, int end)
    {
        for (int i = start, j = end - 1; i < j; ++i, --j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Palindrome_Partitioning_II().minCut("ccaacabacb"));
        System.out.println(System.currentTimeMillis() - start);
    }
}
