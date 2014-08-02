import util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2014/8/2 0002.
 */
public class Surrounded_Regions {
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }

        int m = board.length;
        if (m == 0) {
            return;
        }

        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0 ; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (visited[i][j] > 0) {
                    continue;
                }

                if (board[i][j] == 'X') {
                    visited[i][j] = 1;
                    continue;
                } else {
                    List<Helper> path = new ArrayList<Helper>();
                    boolean pass = false;
                    Queue<Helper> q = new LinkedList<Helper>();
                    q.add(new Helper(i, j));
                    while (!q.isEmpty()) {
                        Helper cur = q.poll();
                        if (isOut(cur.i, cur.j, m, n)) {
                            continue;
                        }

                        if (visited[cur.i][cur.j] == 1) {
                            continue;
                        }

                        if (visited[cur.i][cur.j] == 2) {
                            pass = true;
                            continue;
                        }

                        visited[cur.i][cur.j] = 1;
                        if (board[cur.i][cur.j] == 'X') {
                            continue;
                        } else {
                            if (isPass(cur.i, cur.j, m, n)) {
                                pass = true;
                            }
                            path.add(cur);
                        }

                        q.add(new Helper(cur.i, cur.j+1));
                        q.add(new Helper(cur.i+1, cur.j));
                        q.add(new Helper(cur.i, cur.j-1));
                        q.add(new Helper(cur.i-1, cur.j));
                    }

                    for (Helper h : path) {
                        if (pass) {
                            visited[h.i][h.j] = 2;
                        } else {
                            board[h.i][h.j] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean isPass(int i, int j, int m, int n) {
        return i == 0 || i == m - 1 || j == 0 || j == n - 1;
    }

    private boolean isOut(int i, int j, int m, int n) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }


    static class Helper {
        int i;
        int j;
        Helper (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        char[][] arr = Utils.strArrayTo2DArray(new String[]{
                "OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"
        });

        Utils.print2DCharArray(arr);
        System.out.println();
        new Surrounded_Regions().solve(arr);
        Utils.print2DCharArray(arr);
    }
}
