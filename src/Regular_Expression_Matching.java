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

    public static void main(String[] args) {
        System.out.println(new Regular_Expression_Matching().isMatch("aab", "c*a*b"));
        System.out.println(new Regular_Expression_Matching().isMatch("bbbba", ".*a*a"));
        System.out.println(new Regular_Expression_Matching().isMatch("baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
    }
}
