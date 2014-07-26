/**
 * Created by Administrator on 2014/7/26 0026.
 */
public class Implement_strStr {
    public String strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return null;
        }

        if (haystack.length() == 0 && needle.length() == 0) {
            return "";
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            boolean find = true;
            for (int j = 0 ; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }

            if (find) {
                return haystack.substring(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Implement_strStr().strStr("yyyydreamxxx", "dream"));
    }
}
