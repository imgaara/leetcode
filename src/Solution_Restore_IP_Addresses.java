import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @file	Solution_Restore_IP_Addresses.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-15
 *
 * 
 */
public class Solution_Restore_IP_Addresses
{
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> buff = restoreIpAddresses_(s, 4);
        List<String> result = new ArrayList<String>(); 
        for (List<String> solution : buff) {
            StringBuilder sb = new StringBuilder();
            for (int i = solution.size() - 1; i >= 0; --i) {
                sb.append(solution.get(i)).append('.');
            }
            
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        
        return result;
    }
    
    public List<List<String>> restoreIpAddresses_(String s, int n) {
        List<List<String>> r = new ArrayList<List<String>>();
        if (s.length() > n*3) {
            return r;
        }
        
        if (n == 1) {
            if ((s.length() > 1 && s.startsWith("0")) || Integer.valueOf(s) > 255) {
                return r;
            }
            List<String> list = new ArrayList<String>();
            list.add(s);
            r.add(list);
            return r;
        } else {
            for (int i = 1; i <= 3 && i < s.length(); ++i) {
                String cur = s.substring(0, i);
                if ((cur.length() > 1 && cur.startsWith("0")) || Integer.valueOf(cur) > 255) {
                    continue;
                }
                
                List<List<String>> left = restoreIpAddresses_(s.substring(i), n - 1); 
                if (left.size() == 0) {
                    continue;
                } else {
                    for (List<String> subSolu : left) {
                        subSolu.add(cur);
                        r.add(subSolu);
                    }
                }
            }    
        }
        
        return r;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Restore_IP_Addresses().restoreIpAddresses("010010"));
    }
}
