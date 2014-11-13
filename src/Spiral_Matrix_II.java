/**
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 * Created by www.imgaara.com on 2014/8/12 0012.
 */
public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int begin = 0;
        int end = n - 1;
        int num = 1;
        while (begin < end) {
            for (int j = begin; j < end; ++j) {
                a[begin][j] = num++;
            }

            for (int i = begin; i < end; ++i) {
                a[i][end] = num++;
            }

            for (int j = end; j > begin; --j) {
                a[end][j] = num++;
            }

            for (int i = end; i > begin; --i) {
                a[i][begin] = num++;
            }
            ++begin;
            --end;
        }

        if (begin == end) {
            a[begin][end] = num;
        }

        return a;
    }
}
