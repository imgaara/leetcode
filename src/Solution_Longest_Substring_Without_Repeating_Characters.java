import java.util.Arrays;

public class Solution_Longest_Substring_Without_Repeating_Characters
{
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0;
        int curLen = 0;
        
        boolean[] map = new boolean[255];
        int[] pos = new int[255];

        for (int i = 0 ; i < s.length();) {
            int cur = s.charAt(i);
            if (map[cur]) {
                if (curLen > max) {
                    max = curLen;
                }
                
                for (int j = i - curLen; j <= pos[cur]; ++j) {
                    map[s.charAt(j)] = false;
                }
                
                curLen = i - 1 - pos[cur];
                continue;
            } else {
                map[cur] = true;
                pos[cur] = i;
                ++curLen;
                ++i;
            }
        }
        
        if (curLen > max) {
            max = curLen;
        }
        
        return max;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
