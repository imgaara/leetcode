import util.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2015/1/11 0011.
 */
public class Dungeon_Game {
    public int calculateMinimumHP_0(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] f = new int[m+1][n+1];
        int[] min = new int[m+n+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 1, j = 1; i <= m; ++i) {
            f[i][j] = f[i-1][j] + dungeon[i-1][j-1];
            min[j+j] = f[i][j];
            min[i+j] = Math.min(min[i+j], min[j+j-1]);
        }

        for (int j = 1, i = 1; j <= n; ++j) {
            f[i][j] = f[i][j-1] + dungeon[i-1][j-1];
            min[j+j] = f[i][j];
            min[i+j] = Math.min(min[i+j], min[j+j-1]);
        }

        for (int i = 2; i <= m; ++i) {
            for (int j = 2; j <= n; ++j) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]) + dungeon[i-1][j-1];
                min[i+j] = Math.min(min[i+j], f[i][j]);
                min[i+j] = Math.min(min[i+j], min[i+j-1]);
            }
        }

        for (int l = 2; l <= m + n; ++l) {
            for (int i = 1; i < l; ++i) {
                int j = l - i;

                f[l][i] = Math.max(f[l-1][i], f[l-1][i-1]) + dungeon[i-1][j-1];
            }
        }

        if (min[m+n] >= 0) {
            return 1;
        } else {
            return 1-min[m+n];
        }
    }

    static class Point {
        int i;
        int j;
        Point (int i, int j ) {
            this.i = i;
            this.j = j;
        }
    }



    public int calculateMinimumHP(int[][] dungeon) {
        int i = 0;
        int j = Integer.MAX_VALUE;
        int m = dungeon.length;
        if (m < 1) {
            return 0;
        }
        int n = dungeon[0].length;
        if (n < 1) {
            return 0;
        }

        long[][] f = new long[m+1][n+1];
        boolean[][] hit = new boolean[m+1][n+1];

        while (i <= j) {
            int mid = (i + j) >>> 1;
            long ret = walk(dungeon, mid, f);
            if (ret > 0) {
                j = mid - 1;
            } else if (ret < 0) {
                i = mid + 1;
            } else {
                return mid + 1;
            }
        }

        return j+1 > 0 ? j+1:1;
    }

    private long walk(int[][] dungeon, int h, long[][] f) {
        int orig = dungeon[0][0];
        dungeon[0][0] = orig + h;

        int m = dungeon.length;
        int n = dungeon[0].length;

        for (int i = 0; i <= m; ++i) {
            Arrays.fill(f[i], 0);
        }

        for (int i = 1, j = 1; i <= m; ++i) {
            f[i][j] = f[i-1][j] + dungeon[i-1][j-1];
        }

        for (int j = 1, i = 1; j <= n; ++j) {
            f[i][j] = f[i][j-1] + dungeon[i-1][j-1];
        }

        for (int i = 2; i <= m; ++i) {
            for (int j = 2; j <= n; ++j) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]) + dungeon[i-1][j-1];
            }
        }

        dungeon[0][0] = orig;
        return f[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Dungeon_Game().calculateMinimumHP_0(new int[][]{{0, 5}, {-2, -3}}));
    }
}
