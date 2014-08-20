import util.Reader;

import java.io.IOException;
import java.util.Arrays;



/**
 * 
 */

/**
 * @file Solution_Wildcard_Matching.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-22
 * 
 * 
 */
public class Solution_Wildcard_Matching
{
    public boolean isMatch(String s, String p)
    {
        int[] matrixF = new int[p.length() + 1];
        Arrays.fill(matrixF, s.length() + 1);
        
        return isMatch_(s, 0, p, 0, matrixF);
    }

    public boolean isMatch_(String s, int sp, String p, int pp, int[] matrixF)
    {
        if (p.equals("*")) { return true; }

        int i = sp;
        int j = pp;

        while (j < p.length())
        {
            char cur = p.charAt(j);
            if (cur == '?')
            {
                if (i >= s.length()) 
                {
                    matrixF[pp] = sp;
                    return false; 
                }

                if (i+1 >= matrixF[j+1]) {
                    return false;    
                }

                boolean isMatch = isMatch_(s, i + 1, p, j + 1, matrixF);
                return isMatch;
            }
            else if (cur == '*')
            {
                for (int k = i; k <= s.length(); ++k)
                {
                    if (k >= matrixF[j+1]) {
                        return false;    
                    }

                    boolean subMatch = isMatch_(s, k, p, j + 1, matrixF);
                    if (subMatch)
                    {
                        return true;
                    }
                }
                
                matrixF[j+1] = i;
                return false;
            }
            else
            {
                if (i >= s.length()) 
                {
                    matrixF[pp] = sp;
                    return false; 
                }

                if (cur == s.charAt(i))
                {
                    i++;
                    j++;
                }
                else
                {
                    return false;
                }
                continue;
            }
        }

        return i == s.length() && j == p.length();
    }

    public static void main(String[] args) throws IOException
    {
        java.util.List<String> data = Reader.readLines();

        String S = data.get(0);
        String T = data.get(1);
//        System.out.println(new Solution_Wildcard_Matching().isMatch(S, T));
        System.out.println(new Solution_Wildcard_Matching().isMatch("aa", "*a"));
    }
}
