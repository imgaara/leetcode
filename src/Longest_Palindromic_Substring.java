/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean p[][] = new boolean[n][n];
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                boolean temp = i+1 <= j-1 ? p[i+1][j-1] : true;
                p[i][j] = temp && s.charAt(i) == s.charAt(j);
                if (p[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Palindromic_Substring().longestPalindrome("abb"));
    }
}
