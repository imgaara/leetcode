import java.util.Arrays;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] maxHeightFromThisRow = new int[n];
        int[] furthestLeft = new int[n];
        int[] furthestRight = new int[n];
        Arrays.fill(furthestRight, n);

        int maxArea = 0;
        for (int i = 0; i < m; ++i) {
            int lastLeftCanTo = 0;
            int lastRightCanTo = n; // not include
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    ++maxHeightFromThisRow[j];
                    // 从0到n的收缩过程
                    furthestLeft[j] = Math.max(furthestLeft[j], lastLeftCanTo);
                } else {
                    lastLeftCanTo = j + 1; // position after '0'
                    maxHeightFromThisRow[j] = 0; // 高度被截断
                    furthestLeft[j] = 0; // 重新开始为下一行做准备
                    furthestRight[j] = n;
                }
            }

            for (int j = n -1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    furthestRight[j] = Math.min(furthestRight[j], lastRightCanTo);
                    maxArea = Math.max(maxArea, maxHeightFromThisRow[j] * (furthestRight[j] - furthestLeft[j]));
                } else {
                    lastRightCanTo = j;
                }
            }
        }

        return maxArea;
    }
}
