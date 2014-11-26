import util.Reader;

import java.io.IOException;
import java.util.Arrays;



/**
 * 
 */

/**
 * @file Solution_Jump_Game.java
 * @package
 * @project ZTest
 * @author www.imgaara.com
 * @time 2014-6-22
 * 
 * 
 */
public class Jump_Game
{
    public boolean canJump(int[] A)
    {
        int step = A[0];

        for (int i = 1; i < A.length; ++i) {
            if (step > 0) {
                // can next i,
                // to next i, modify left steps
                --step;
                step = Math.max(A[i], step);
            } else {
                // used all stpes
                return false;
            }
        }

        return true;
    }

    public boolean canJump2(int[] A)
    {
        int far = 1;

        for (int i = 0; i < far; ++i) {
            if (i >= A.length) {
                return true;
            }
            far = Math.max(far, i + A[i]);
        }

        return false;
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
        
        System.out.println(new Jump_Game().canJump(B));
    }

}
