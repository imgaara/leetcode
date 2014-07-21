/**
 * Created by Administrator on 2014/7/21 0021.
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            final int alphaI = isAlpha(s, i);
            final int numberI = isNumber(s, i);
            final int alphaJ = isAlpha(s, j);
            final int numberJ = isNumber(s, j);

            if (alphaI == -1 && numberI == -1) {
                ++i;
                continue;
            }

            if (alphaJ == -1 && numberJ == -1) {
                --j;
                continue;
            }

            if ((alphaI != -1 && alphaJ != -1) && (alphaI == alphaJ) || (numberI != -1 && numberJ != -1) && (numberI == numberJ)) {
                ++i;
                --j;
            } else {
                return false;
            }
        }

        return true;
    }

    private int isAlpha(String s, int pos) {
        char ch = s.charAt(pos);
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        } else if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        } else {
            return -1;
        }
    }

    private int isNumber(String s, int pos) {
        char ch = s.charAt(pos);
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Valid_Palindrome().isPalindrome("ab"));
    }
}
