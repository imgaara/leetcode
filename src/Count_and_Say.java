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
public class Count_and_Say
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

    public String countAndSay2(int n) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.append("1");

        while (n-- > 1) {
            int k = 0;
            for (int i = 0; i < s1.length() ; ) {
                if (k != 0 && s1.charAt(i) != s1.charAt(i - 1)) {
                    char num = s1.charAt(i-1);
                    s2.append(k).append(num);
                    k = 0;
                } else {
                    i++;
                    k++;
                }
            }

            s2.append(k).append(s1.charAt(s1.length() - 1));
            StringBuilder temp = s1;
            s1 = s2;
            s2 = temp;
            s2.delete(0, s2.length());
        }

        return s1.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Count_and_Say().countAndSay(2));
        
    }
}
