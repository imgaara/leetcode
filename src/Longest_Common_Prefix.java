public class Longest_Common_Prefix
{
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || strs.length == 0) {
                return "";
            }
            
            if (strs.length == 1) {
                return strs[0];
            }
            
            int minLen = Integer.MAX_VALUE;
            
            for (int i = 0 ; i  < strs.length; ++i) {
                if (strs[i].length() < minLen) {
                    minLen = strs[i].length();
                }
            }
            
            int len = 0;
            for (int i = 0; i < minLen; ++i) {
                for (int j = 1; j < strs.length; ++j) {
                    if (strs[0].charAt(i) != strs[j].charAt(i)) {
                        return strs[0].substring(0, len);
                    }
                }
                
                ++len;
            }
            
            return strs[0].substring(0, len);
        }
    }
}
