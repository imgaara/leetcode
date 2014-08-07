import java.io.IOException;
import java.util.Arrays;

import tools.Reader;


/**
 * 
 */

/**
 * @file Solution_Jump_Game.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-22
 * 
 * 
 */
public class Solution_Jump_Game
{
    public boolean canJump(int[] A)
    {

        boolean[] matrix = new boolean[A.length];
        Arrays.fill(matrix, true);
        return canJump_(A, 0, matrix);
    }

    private boolean canJump_(int[] A, int start, boolean[] matrix)
    {
        if (start >= A.length - 1) { return true; }

        int maxJump = A[start];
        if (maxJump == 0)
        {
            matrix[start] = false;
            return false;
        }

        for (int jump = 1; jump <= maxJump; --jump)
        {
            int nextStart = start + jump;
            if (nextStart >= A.length - 1) { return true; }
            
            if (!matrix[nextStart])
            {
                continue;
            }

            boolean can = canJump_(A, nextStart, matrix);
            if (can) { return true; }
        }

        matrix[start] = false;
        return false;
    }
    
    private int findMaxJump_(int start, int maxJump, int len) {
        int i = start + 1;
        int j = start + maxJump;
        
        int mid = 0;
        while (i <= j) {
            mid = (i + j) >>> 1;
            if (mid == len - 1) {
                return mid - start;
            } else if (mid > len - 1) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        
        return j - start;
    }

    public static void main(String[] args) throws IOException
    {
        java.util.List<String> data = Reader.readLines();

        String S = data.get(0);
        String[] list = S.split(",");
        int[] A = new int[list.length];
        int count = 0;
        for (String s : list) {
            A[count++] = Integer.valueOf(s);
        }
        
        int[] B = new int[25002];
        for (int i = 0; i < 25001; ++i) {
            B[i] = 25000 - i;
        }
        
        System.out.println(new Solution_Jump_Game().canJump(B));
    }

}
