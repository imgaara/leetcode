import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        int[][] notMatch = new int[m][n];
        for (int i = 0; i < notMatch.length; ++i) {
            Arrays.fill(notMatch[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (find(board, m, n, i, j, word, 0, used, notMatch)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int m, int n , int curi, int curj, String word, int cur, boolean[][] used, int[][] notMatch) {
        if (cur >= word.length()) {
            return true;
        }

        if (curi >= m || curj >= n || curi < 0 || curj < 0) {
            return false;
        }

        if (used[curi][curj]) {
            return false;
        }

        if (notMatch[curi][curj] == cur) {
            return false;
        }

        if (board[curi][curj] == word.charAt(cur)) {
            used[curi][curj] = true;
            if(find(board, m, n, curi, curj+1, word, cur+1, used, notMatch)) {
                return true;
            }

            if(find(board, m, n, curi+1, curj, word, cur+1, used, notMatch)) {
                return true;
            }

            if(find(board, m, n, curi, curj-1, word, cur+1, used, notMatch)) {
                return true;
            }

            if(find(board, m, n, curi-1, curj, word, cur+1, used, notMatch)) {
                return true;
            }
            used[curi][curj] = false;
        }

        if (notMatch[curi][curj] < cur) {
            notMatch[curi][curj] = cur;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Word_Search().exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
    }
}
