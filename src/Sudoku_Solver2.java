import util.Utils;

/**
 * Created by Administrator on 2014/7/30 0030.
 */
public class Sudoku_Solver2 {

    public void solveSudoku(char[][] board) {
        boolean[][] box = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char cur = board[i][j];
                if ('.' == cur) {
                    continue;
                }

                int numberId = cur - '1';
                int blockId = (i / 3) * 3 + (j / 3);

                row[i][numberId] = true;
                col[j][numberId] = true;
                box[blockId][numberId] = true;
            }
        }

        DFS(board, 0, 0, box, row, col);
    }

    private boolean DFS(char[][] board, int i, int j, boolean[][] box, boolean[][] row, boolean[][] col) {
        if (j >= 9) {
            j = 0;
            i++;
        }

        while (i < 9 && j < 9) {
            if (board[i][j] == '.') {
                for (int k = 0; k < 9; ++k) {
                    int blockId = (i / 3) * 3 + (j / 3);
                    if (row[i][k] || col[j][k] || box[blockId][k]) {
                        continue;
                    }

                    board[i][j] = (char)('1' + k);
                    row[i][k] = true;
                    col[j][k] = true;
                    box[blockId][k] = true;

                    if(DFS(board, i, j + 1, box, row, col)) {
                        return true;
                    }

                    board[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    box[blockId][k] = false;
                }
                return false;
            }

            j++;
            if (j >= 9) {
                j = 0;
                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = Utils.strArrayTo2DArray(new String []{
                ".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."
        });

        long start = System.currentTimeMillis();
        new Sudoku_Solver2().solveSudoku(board);
        for (int i = 0; i < board.length; ++i) {
            System.out.println(board[i]);
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
