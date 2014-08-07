/**
 * 
 */

/**
 * @file Solution_Valid_Sudoku.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-7-13
 * 
 * 
 */
public class Solution_Valid_Sudoku
{
    public boolean isValidSudoku(char[][] board)
    {
        boolean[][] numberInRow = new boolean[9][9];
        boolean[][] numberInCol = new boolean[9][9];
        boolean[][] numberInBlock = new boolean[9][9];
        
        
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cur = board[i][j];
                if ('.' == cur) {
                    continue;
                }
                
                int numberId = cur - '1'; 
                int blockId = (i / 3) * 3 + (j / 3);
                if (numberInRow[i][numberId] || numberInCol[j][numberId] || numberInBlock[blockId][numberId]) {
                    return false;
                } else {
                    numberInRow[i][numberId] = true;
                    numberInCol[j][numberId] = true;
                    numberInBlock[blockId][numberId] = true;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        String[] ss = {".........","4........","......6..","...38....",".5...6..1","8......6.",".........","..7.9....","...6....."};
        char[][] board = new char[9][];
        for (int i = 0 ; i < 9; ++i) {
            board[i] = ss[i].toCharArray();
        }
        
        System.out.println(new Solution_Valid_Sudoku().isValidSudoku(board));
    }
}
