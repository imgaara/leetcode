import java.util.Arrays;

public class Longest_Substring_Without_Repeating_Characters
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

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int[] map = new int[Character.MAX_VALUE];
        Arrays.fill(map, -1);
        int max = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (map[ch] >= start) {
                int len = i - start;
                if (len > max) {
                    max = len;
                }
                start = map[ch] + 1;
            }

            map[ch] = i;
        }

        int last = s.length() - start;
        return last > max ? last : max;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}
