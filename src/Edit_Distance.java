/**
 * Created by Administrator on 2014/8/24 0024.
 */
public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int[][] d = new int[word1.length()+1][word2.length()+1];
        d[0][0] = 0;

        for (int i = 1; i <= word1.length(); ++i) {
            d[i][0] = i;
        }

        for (int j = 1; j <= word2.length(); ++j) {
            d[0][j] = j;
        }

        for (int i = 1; i < word1.length()+1; ++i) {
            for (int j = 1; j < word2.length()+1; ++j) {

                int ii = d[i-1][j] + 1;
                int dd = d[i][j-1] + 1;
                int rr = d[i-1][j-1] +  ((word1.charAt(i-1) == word2.charAt(j-1)) ?  0 : 1);

                d[i][j] = Math.min(Math.min(ii, dd), rr);
            }
        }

        return d[word1.length()][word2.length()];
    }
}
