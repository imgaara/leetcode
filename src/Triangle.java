import java.util.List;

/**
 * Created by Administrator on 2014/8/24 0024.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }

        int[] minInRow = new int[triangle.size()];
        int[] buff = new int[triangle.size()];
        minInRow[0] = triangle.get(0).get(0);

        for (int row = 1; row < triangle.size(); ++row) {
            for (int i = 0; i < triangle.get(row).size(); ++i) {
                final int cur = triangle.get(row).get(i);
                if (0 == i) {
                    buff[i] = minInRow[i] + cur;
                } else if (triangle.get(row).size() - 1 == i)  {
                    buff[i] = minInRow[i-1] + cur;
                } else {
                    buff[i] = Math.min(minInRow[i], minInRow[i-1]) + cur;
                }
            }

            int[] tmp = minInRow;
            minInRow = buff;
            buff = tmp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minInRow.length; ++i) {
            if (minInRow[i] < min) {
                min = minInRow[i];
            }
        }

        return min;
    }
}
