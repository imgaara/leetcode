import java.util.ArrayList;
import java.util.List;

/**
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 * @author www.imgaara.com on 2014/7/27 0027.
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;

        for (int r = 0; r <= (m + 1) / 2 - 1; ++r) {
            int i = r;
            int j = r;
            if (j >= n - r) {
                continue;
            }

            while (j < n - r) {
                result.add(matrix[i][j]);
                j++;
            }

            j--;
            i++;
            if (i >= m - r) {
                continue;
            }

            while (i < m - r) {
                result.add(matrix[i][j]);
                i++;
            }

            i--;
            j--;
            if (j < r) {
                continue;
            }

            while (j >= r) {
                result.add(matrix[i][j]);
                j--;
            }

            j++;
            i--;
            if (i <= r) {
                continue;
            }

            while (i > r) {
                result.add(matrix[i][j]);
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Spiral_Matrix().spiralOrder(new int[][] {{3,2}}));
    }
}
