/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (null == s1 || null == s2 || null == s3) {
            return false;
        }

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] notMatch = new boolean[s1.length() + 1][s2.length() + 1];
        return isInterleave_(s1, 0, s2, 0, s3, 0, notMatch);
    }

    private boolean isInterleave_(String s1, int i, String s2, int j, String s3, int k, boolean[][] notMatch) {
        if (i >= s1.length() && j >= s2.length() && k >= s3.length()) {
            return true;
        }

        if (k >= s3.length()) {
            return false;
        }

        if (notMatch[i][j]) {
            return false;
        }

        char ch3 = s3.charAt(k);
        if (i < s1.length() && ch3 == s1.charAt(i)) {
            if (isInterleave_(s1, i+1, s2, j, s3, k+1, notMatch)) {
                return true;
            }
        }

        if (j < s2.length() && ch3 == s2.charAt(j)) {
            if (isInterleave_(s1, i, s2, j+1, s3, k+1, notMatch)) {
                return true;
            }
        }

        notMatch[i][j] = true;

        return false;
    }
}
