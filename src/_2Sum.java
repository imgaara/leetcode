import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/10 0010.
 */
public class _2Sum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; ++i) {
            m.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; ++i) {
            int a = numbers[i];
            int b = target - a;
            Integer index = m.get(b);
            if (null != index) {
                if (index != i) {
                    return new int[]{Math.min(i+1, index+1), Math.max(i+1, index+1)};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ret = new _2Sum().twoSum(new int[]{3,2,4}, 6);
        System.out.println("" + ret[0] + ret[1]);
    }
}
