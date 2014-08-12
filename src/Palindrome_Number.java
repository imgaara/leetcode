/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int sum = 0;
        int left = x;

        while (left != 0) {
            int cur = left % 10;

            if (sum > (Integer.MAX_VALUE - cur) / 10) {
                return false;
            }

            sum = sum * 10 + cur;
            left = left / 10;
        }

        return sum == x;
    }
}
