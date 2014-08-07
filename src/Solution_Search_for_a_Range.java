/**
 * 
 */

/**
 * @file Solution_Search_for_a_Range.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-7
 * 
 * 
 */
public class Solution_Search_for_a_Range
{
    public int[] searchRange(int[] A, int target)
    {
        int i = 0;
        int j = A.length - 1;

        while (i <= j)
        {
            int mid = (i + j) >>> 1;
            System.out.printf("i=%d, j=%d, mid=%d\n", i, j,mid);
            if (A[mid] >= target)
            {
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }

        int left = i;
        while (left <  A.length) {
            System.out.println("while");
            if (A[left] == target) {
                break;
            }
            ++left;
        }
        
        if (left < 0) { return new int[] { -1, -1 }; }

        i = 0;
        j = A.length - 1;

        while (i <= j)
        {
            
            int mid = (i + j) >>> 1;
            System.out.printf("i=%d, j=%d, mid=%d\n", i, j,mid);
            if (A[mid] > target)
            {
                j = mid - 1;
            }
            else
            {
                i = mid + 1;
            }
        }

        int right = j;
        while (right >= 0) {
            System.out.println("while");
            if (A[right] == target) {
                return new int[] { left, right };
            }
            --right;
        }
        
        return new int[] { -1, -1 };
    }
    
    public static void main(String[] args)
    {
        int[] pair = new Solution_Search_for_a_Range().searchRange(new int[] {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9}, 8);
        System.out.println(pair[0]);
        System.out.println(pair[1]);
    }
}
