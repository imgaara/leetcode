import util.Utils;

/**
 * Created by Administrator on 2014/7/30 0030.
 */
public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
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

                numberInRow[i][numberId] = true;
                numberInCol[j][numberId] = true;
                numberInBlock[blockId][numberId] = true;
            }
        }

        Helper next = nextIJ(0, -1, board);
        if (null == next) {
            return;
        }
        solveSudoku(board, next.i, next.j, numberInRow, numberInCol, numberInBlock);
    }

    private boolean solveSudoku(char[][] board, final int i, final int j, boolean[][] numberInRow, boolean[][] numberInCol, boolean[][] numberInBlock) {
        if (i >= 9) {
            return true;
        }

        int blockId = (i / 3) * 3 + (j / 3);
        for (int k = 0; k < 9; ++k) {
            if (numberInRow[i][k] || numberInCol[j][k] || numberInBlock[blockId][k]) {
                continue;
            }

            numberInRow[i][k] = true;
            numberInCol[j][k] = true;
            numberInBlock[blockId][k] = true;
            board[i][j] = (char)('1' + k);

            Helper next = nextIJ(i, j, board);
            if (null == next) {
                return true;
            }

            if(solveSudoku(board, next.i, next.j, numberInRow, numberInCol, numberInBlock)) {
                return true;
            }

            board[i][j] = '.';
            numberInRow[i][k] = false;
            numberInCol[j][k] = false;
            numberInBlock[blockId][k] = false;
        }

        return false;
    }

    static class Helper {
        final int i;
        final int j;
        Helper(int i , int j) {
            this.i = i;
            this.j = j;
        }
    }

    private Helper nextIJ(int i, int j, char[][] board) {
        int nextI = i;
        int nextJ = j;
        while (nextI < 9) {
            if (nextJ == 8) {
                nextI = nextI + 1;
                nextJ = 0;
            } else {
                nextJ = nextJ + 1;
            }

            if (nextI < 9 && board[nextI][nextJ] == '.') {
                break;
            }
        }

        return nextI < 9 ? new Helper(nextI, nextJ) : null;
    }

    public static void main(String[] args) {
        char[][] board = Utils.strArrayTo2DArray(new String[]{
                ".....7..9", ".4..812..", "...9...1.", "..53...72", "293....5.", ".....53..", "8...23...", "7...5..4.", "531.7...."
        });

        long start = System.currentTimeMillis();
        new Sudoku_Solver().solveSudoku(board);
        for (int i = 0; i < board.length; ++i) {
            System.out.println(board[i]);
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
