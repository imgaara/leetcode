/**
 * 
 */

/**
 * @file	Solution_N_Queens_II.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-28
 *
 * 
 */
public class Solution_N_Queens_II
{
    public int totalNQueens(int n) {
        int[] status = new int[n];
        return totalNQueens_(0, n, n, status);
    }
    
    private int totalNQueens_(int startCol, int n , int size,  int[] status) {
        if (0 == n) {
            return 1;
        }
        
        int count = 0;
        int i = startCol;
        for (int j = 0; j < size; ++j) {
            if (canPlace_(i, j, status)) {
                status[i] = j;
                count += totalNQueens_(i+1, n-1, size, status);
            }
        }
        
        return count;
    }
    
    private boolean canPlace_(int col, int row , int[] status) {
        for (int i = 0; i < col; ++i) {
            int rowOthers = status[i];
            if (rowOthers == row) {
                return false;
            } else if (row - rowOthers == col - i) {
                return false;
            } else if (row - rowOthers == i - col ) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_N_Queens_II().totalNQueens(14));
    }
}
