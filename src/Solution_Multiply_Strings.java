/**
 * 
 */

/**
 * @file	Solution_Multiply_Strings.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-7-18
 *
 * 
 */
public class Solution_Multiply_Strings
{
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        for (int j = num2.length() - 1; j >= 0; --j) {
            int c = 0;
            for (int i = num1.length() - 1; i >= 0; --i) {
                int pos = num2.length() + num1.length() - 2 - j - i;
                int sk = pos < sb.length() ? (sb.charAt(pos) - '0') : 0;
                int a = num2.charAt(j) - '0';
                int b = num1.charAt(i) - '0';
                int s = a * b + sk + c;
                c = s / 10;
                if (pos < sb.length()) {
                    sb.setCharAt(pos, (char) ('0' + (s % 10)));
                } else {
                    sb.append(s % 10);
                }
            }
            
            if (c > 0) {
                sb.append(c % 10);
            }
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Multiply_Strings().multiply("98", "9"));
    }
}
