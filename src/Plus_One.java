/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return digits;
        }

        int c = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            int cur = digits[i] + c;
            digits[i] = cur % 10;
            c = cur / 10;
        }

        if (c == 0) {
            return digits;
        } else {
            int[] nn = new int[digits.length + 1];
            System.arraycopy(digits, 0, nn , 1, digits.length);
            nn[0] = c;
            return nn;
        }
    }
}
