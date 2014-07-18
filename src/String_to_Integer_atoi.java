/**
 * 
 */

/**
 * @file	String_to_Integer_atoi.java
 * @package	
 * @project	leetcode
 * @author	Administrator
 * @time	2014-7-18
 * @crop	Rampage inc.
 *
 * 
 */
public class String_to_Integer_atoi
{
    public int atoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        for (; i < str.length() && (str.charAt(i) == ' ' || str.charAt(i) == '\t'); ++i);
        
        if (i >= str.length()) {
            return 0;
        }
        
        int sign = isSign_(str.charAt(i));
        if (sign != 0) {
            ++i;
        }
        boolean isNeg = sign == -1;
        long sum = 0;
        
        for (; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (!isDigit_(ch)) {
                return (int) sum;
            }
            
            int cur = ch - '0';
            if (isNeg) {
                sum = sum * 10 - cur;
                if (sum < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                sum = sum * 10 + cur;
                if (sum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        
        return (int) sum;
    }
    
    private int isSign_(char ch) {
        if ('-' == ch) {
            return -1;
        } else if ('+' == ch) {
            return 1;
        } else return 0;
    }
    
    private boolean isDigit_(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
