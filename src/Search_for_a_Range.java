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
public class Search_for_a_Range
{
    public int[] searchRange(int[] A, int target)
    {
        int i = 0;
        int j = A.length - 1;

        while (i != j) {
            int mid = (i + j) >>> 1;
            System.out.printf("i=%d, j=%d, mid=%d\n", i, j,mid);
            if (A[mid] < target) {
                i = ++mid;
            } else {
                j = mid;
            }
        }

        int left = i;

        i = 0;
        j = A.length - 1;

        while (i < j)
        {
            int mid = (i + j) >>> 1;
            System.out.printf("i=%d, j=%d, mid=%d\n", i, j,mid);
            if (A[mid] <= target) {
                i = mid+1;
            } else {
                j = mid;
            }
        }

        System.out.printf("i=%d, j=%d\n", i, j);
        int right = A[i] == target ? i : i - 1;
        if (left == A.length || A[left] != target) {
            return new int[] {-1, -1};
        }

        return new int[] { left, right};
    }
    
    public static void main(String[] args)
    {
        int[] pair = new Search_for_a_Range().searchRange(new int[] {2,2}, 3);
        System.out.println(pair[0]);
        System.out.println(pair[1]);
    }
}
