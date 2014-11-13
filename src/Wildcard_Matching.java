import java.util.PriorityQueue;

/**

 Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false



 * Created by www.imgaara.com on 2014/11/13 0013.
 */
public class Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        boolean hasStar = false;
        int curS = 0;
        int curP = 0;
        int i;
        int j;
        for (i = 0, j = 0; i != s.length(); ++i, ++j) {

            char pChar = j == p.length() ? (char)-1 : p.charAt(j);
            switch (pChar) {
                case '?' :
                    break;
                case '*' :
                    hasStar = true;
                    curP = j;
                    curS = i;
                    while (curP < p.length() && p.charAt(curP) == '*') {
                        curP++;
                    }

                    if (curP == p.length()){
                        return true;
                    } else {
                        i = curS - 1;
                        j = curP - 1;
                    }
                    break;
                default:
                    if (pChar != s.charAt(i)) {
                        if (!hasStar) {
                            return false;
                        } else {
                            curS++;
                            i = curS - 1;
                            j = curP - 1;
                        }
                    }
                    break;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
