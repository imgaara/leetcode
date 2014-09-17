/**
 * Created by Administrator on 2014/7/31 0031.
 */
public class Decode_Ways {

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return s.equals("0") ? 0 : 1;
        }

        int[] f = new int[s.length()];
        f[s.length() - 1] = 1;

        for (int i = s.length() - 2; i >= 0; i--) {
            final char cur = s.charAt(i);
            final char cur1 = s.charAt(i + 1);

            if (cur1 == '0') {
                if (cur == '0' || cur > '2') {
                    f[i] = 0;
                } else {
                    f[i] = f[i+1];
                }
            } else {
                f[i] = f[i + 1];
                if (i + 2 < s.length()) {
                    final char cur2 = s.charAt(i + 2);
                    if (cur2 != '0' && (cur == '1' || (cur == '2' && cur1 <= '6'))) {
                        f[i] += f[i + 2];
                    }
                } else {
                    if (cur == '1' || (cur == '2' && cur1 <= '6')) {
                        f[i] += f[i+1];
                    }
                }
            }
        }

        return s.charAt(0) == '0' ? 0 : f[0];
    }

    public int numDecodings_2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = s.charAt(0) > '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); ++i) {
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                f[i] += f[i - 2];
            }

            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
        }

        return f[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(new Decode_Ways().numDecodings("001"));
    }
}
