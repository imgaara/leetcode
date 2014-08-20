import util.Reader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 */

/**
 * @file	Solution_Distinct_Subsequences.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-21
 *
 * 
 */
public class Distinct_Subsequences
{
    public int numDistinct(String S, String T) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < T.length(); ++i) {
            set.add(T.charAt(i));
        }
        
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (set.contains(ch)) {
                sb.append(ch);
            }
        }
        
        String SS = sb.toString();
        
        int[][] matrix = new int[SS.length() + 1][T.length() + 1];
        for (int i = 0; i <= SS.length(); ++i) {
            matrix[i] = new int[T.length() + 1];
            Arrays.fill(matrix[i], -1);
        }
       
        return numDistinct_(SS, 0, T, 0, matrix);
    }
    
    private int numDistinct_(String S, int p1, String T, int p2, int[][] matrix) {
        if (S.length() - p1 < T.length() - p2) {
            return 0;
        }
        
        if (T.length() - p2 == 0) {
            return 1;
        }
        
        int count = 0;
        for (int i = p1; i < S.length() && (S.length() - 1 - i >= T.length() - 1 - p2); ++i) {
            char cur = S.charAt(i);
            if (cur == T.charAt(p2)) {
                if (matrix[i+1][p2+1] != -1) {
                    count += matrix[i+1][p2+1];
                } else {
                    int subCount = numDistinct_(S, i + 1, T, p2 + 1, matrix);
                    matrix[i+1][p2+1] = subCount;
                    
                    count += subCount;
//                    matrix[i][p2] = count;
//                    for (int j = i-1; j >= p1 && S.charAt(j) != T.charAt(p2);--j) {
//                        matrix[j][p2] = count;
//                    }
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) throws IOException
    {
        java.util.List<String> data = Reader.readLines();
        
        String S = data.get(0);
        String T = data.get(1);
        System.out.println(new Distinct_Subsequences().numDistinct("rabbbit", "rabbit"));
    }
}
