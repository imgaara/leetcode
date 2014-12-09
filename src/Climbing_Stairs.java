/**
 * Created by Administrator on 2014/8/24 0024.
 */
public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        int[] map = new int[n+1];
        return climbStairs_(n, map);
    }

    private int climbStairs_(int n, int[] map) {
        if (0 == n) {
            return 1;
        }

        if (1 == n) {
            return 1;
        }

        if (map[n] != 0) {
            return map[n];
        }

        map[n - 1] = climbStairs_(n - 1, map);
        map[n - 2] = climbStairs_(n - 2, map);
        return map[n-1] + map[n-2];
    }



    public int climbStairs3(int n) {
        int prev = 1;
        int cur = 1;

        for (int i = 2; i <= n; ++i) {
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }

        return cur;
    }
}
