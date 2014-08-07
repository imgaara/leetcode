/**
 * 
 */

/**
 * @file Solution_Count_and_Say.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-18
 * @crop Rampage inc.
 * 
 * 
 */
public class Solution_Count_and_Say
{
    public String countAndSay(int n)
    {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; ++i) {
            StringBuilder buffer = new StringBuilder();
            
            for (int cur = 0; cur < sb.length();) {
                int count = 0;
                int end = cur;
                for (; end < sb.length() && sb.charAt(end) == sb.charAt(cur); ++end, ++count) {
                }
                
                buffer.append(String.valueOf(count)).append(sb.charAt(cur));
                cur = end;
            }
            
            sb = buffer;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Count_and_Say().countAndSay(2));
        
    }
}
