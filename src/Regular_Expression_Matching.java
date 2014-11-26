import java.util.Arrays;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p)
    {
        return isMatch_(s, 0, p, 0);
    }

    public boolean isMatch_(String s, int sp, String p, int pp)
    {
        if (sp >= s.length() && pp >= p.length()) {
            return true;
        }

        if (sp < s.length() && pp >= p.length()) {
            return false;
        }

        int i = sp;
        int j = pp;

        char cur = p.charAt(j);
        if (isNextStar(p, j)) {
            int k = i;
            while (k < s.length()) {
                if (s.charAt(k) == cur || cur == '.'){
                    if (isMatch_(s, k, p, j + 2)) {
                        return true;
                    }
                } else {
                    break;
                }

                k++;
            }

            return isMatch_(s, k, p, j + 2);
        } else {
            if (i < s.length() && (s.charAt(i) == cur || cur == '.')) {
                return isMatch_(s, i + 1, p, j + 1);
            } else {
                return false;
            }
        }
    }

    private boolean isNextStar(String s, int idx) {
        int next = idx + 1;
        if (next >= s.length()) {
            return false;
        }

        return s.charAt(next) == '*';
    }


    public boolean isMatch2(String s, String p) {
        return isMatch2_(s, 0, p, 0);
    }

    private boolean isMatch2_(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        char curS = i < s.length() ? s.charAt(i) : (char) - 1;
        char curP = p.charAt(j);
        char next = j < p.length() - 1 ?  p.charAt(j + 1) : (char) -1;
        if ('*' != next) {
            if (curS == curP || (curP == '.' && curS != (char)-1)) {
                return isMatch2_(s, i + 1, p, j + 1);
            } else {
                return false;
            }
        } else {

            while (curS == curP || (curP == '.' && curS != (char)-1)) {
                if (isMatch2_(s, i , p, j + 2)) {
                    return true;
                }
                i++;
                curS = i < s.length() ? s.charAt(i) : (char) - 1;
            }

            return isMatch2_(s, i , p, j + 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Regular_Expression_Matching().isMatch2("ab", ".*c"));
        System.out.println(new Regular_Expression_Matching().isMatch("aab", "c*a*b"));
        System.out.println(new Regular_Expression_Matching().isMatch("bbbba", ".*a*a"));
        System.out.println(new Regular_Expression_Matching().isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
    }
}
