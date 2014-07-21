import java.util.Arrays;

/**
 * Created by Administrator on 2014/7/21 0021.
 */
public class Scramble_String {
    public boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!Arrays.equals(arr1, arr2)) {
            return false;
        }

        int len = s1.length();

        for (int subLen = 1; subLen < len; ++subLen) {
            String s11 = s1.substring(0, subLen);
            String s12 = s1.substring(subLen);

            {
                String s21 = s2.substring(0, subLen);
                String s22 = s2.substring(subLen);
                if (isScramble(s11, s21) && isScramble(s12, s22)) {
                    return true;
                }
            }

            {
                String s21 = s2.substring(len - subLen);
                String s22 = s2.substring(0, len - subLen);
                if (isScramble(s11, s21) && isScramble(s12, s22)) {
                    return true;
                }
            }
        }

        return false;
    }
}
