import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if (null == s || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isMatch = new boolean[s.length()+1];

        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur == '('){
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                } else {
                    int top = stack.pop();
                    isMatch[i] = true;
                    isMatch[top] = true;
                }
            }
        }

        int max = 0;
        int start;
        for (int i = 0; i < s.length();) {
            if (isMatch[i]) {
                start = i;
                for (int j = i+1; j <= s.length(); ++j) {
                    if (!isMatch[j]) {
                        int len = j - start;
                        if (len > max) {
                            max = len;
                        }
                        i = j + 1;
                        break;
                    }
                }
            } else {
                i++;
            }
        }

        return max;
    }

    public int longestValidParentheses2(String s) {
        final int N = s.length();
        if (N < 2) {
            return 0;
        }

        if (N == 2) {
            return s.equals("()") ? 2 : 0;
        }

        if (N == 3) {
            if (s.equals("(()") || s.equals("())")) {
                return 2;
            } else {
                return 0;
            }
        }

        boolean[][] d = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            d[i][i] = false;
            if (i+1 < N) {
                d[i][i+1] = (s.charAt(i) == '(' && s.charAt(i+1) == ')');
            }
        }

        int max = 0;
        for (int k = 3; k < N; k += 2) {
            for (int i = 0; i < N; ++i) {
                int j = i + k;
                if (j < N) {
                    boolean isSub = d[i][i+1] && d[i+2][j];
                    isSub = isSub || (s.charAt(i) == '(' && s.charAt(j) == ')' && d[i+1][j-1]);
                    isSub = isSub || (d[j-1][j] && d[i][j-2]);

                    d[i][j] = isSub;
                    if (isSub) {
                        if (j - i > max) {
                            max = j - i;
                        }
                    }
                }
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Valid_Parentheses().longestValidParentheses(")("));
    }
}
