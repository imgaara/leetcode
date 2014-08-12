import java.util.*;


/**
 *
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 @author www.imgaara.com

 */
public class Minimum_Window_Substring
{
    public class Solution
    {
        public String minWindow(String S, String T)
        {
            Set<Character> s = new HashSet<Character>();

            int[] counter = new int[60];
            int[] expected = new int[60];

            for (int i = 0; i < T.length(); ++i)
            {
                counter[T.charAt(i) - 'A'] = 0;
                s.add(T.charAt(i));
            }

            for (int i = 0; i < T.length(); ++i)
            {
                char ch = T.charAt(i);
                ++expected[ch - 'A'];
            }

            int start = 0;
            int end = 0;
            int minlen = Integer.MAX_VALUE;
            int minStart = 0;
            int minEnd = 0;
            while (end <= S.length())
            {
                if (end - start >= T.length() && coverAll(counter, expected, s))
                {
                    if (minlen > end - start)
                    {
                        minlen = end - start;
                        minStart = start;
                        minEnd = end;
                    }

                    if (start < end)
                    {
                        char ch = S.charAt(start);
                        --counter[ch - 'A'];
                        ++start;
                    }
                    else
                    {
                        if (end < S.length())
                        {
                            char ch = S.charAt(end);
                            ++counter[ch - 'A'];
                            ++end;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else
                {
                    if (end < S.length())
                    {
                        char ch = S.charAt(end);
                        ++counter[ch - 'A'];
                        ++end;
                    }
                    else
                    {
                        break;
                    }
                }
            }

            if (minlen != Integer.MAX_VALUE)
            {
                return S.substring(minStart, minEnd);
            }
            else
            {
                return "";
            }
        }

        private boolean coverAll(int[] counter, int[] expected, Set<Character> s)
        {
            for (char ch : s)
            {
                if (counter[ch - 'A'] < expected[ch - 'A']) { return false; }
            }

            return true;
        }
    }
}
