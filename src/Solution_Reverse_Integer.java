/**
 * 
 */

/**
 * @file Solution_Reverse_Integer.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-24
 * @crop Rampage inc.
 * 
 * 
 */
public class Solution_Reverse_Integer
{
    public int reverse(int x) {
        int sum = 0;
        int left = x;
        boolean isNeg = x < 0;
        
        while (left != 0) {
            int cur = left % 10;
            
            if (isNeg && sum < (Integer.MIN_VALUE - cur) / 10) {
                return x;
            } 
            
            if (!isNeg && sum > (Integer.MAX_VALUE - cur) / 10) {
                return x;
            }
            
            sum = sum * 10 + cur;
            left = left / 10;
        }
        
        return sum;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Reverse_Integer().reverse(-1999999999));
    }
}
