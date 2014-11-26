/**
 * Created by Administrator on 2014/11/26 0026.
 */
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; ++i) {
            for (int k = 1; k < n; ++k) {
                f[i] += f[k - 1] * f[i - k];
            }
        }

        return f[n];
    }
}
