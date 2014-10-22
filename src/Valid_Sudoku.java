import util.Utils;

/**
 * Created by Administrator on 2014/10/22 0022.
 */
public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] box = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';
                if (row[i][num]) {
                    return false;
                } else {
                    row[i][num] = true;
                }

                if (col[j][num]) {
                    return false;
                } else {
                    col[j][num] = true;
                }

                int boxI = i / 3 * 3 + j / 3;
                if (box[boxI][num]) {
                    return false;
                } else {
                    box[boxI][num] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Valid_Sudoku().isValidSudoku(Utils.strArrayTo2DArray(new String[]{"..4...63.", ".........", "5......9.", "...56....", "4.3.....1", "...7.....", "...5.....", ".........", "........."})));
    }
}
