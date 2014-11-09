import java.util.*;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        DFS(n, 0, 0, cur, ret);
        return ret;
    }

    private void DFS(int n, int left, int right, StringBuilder cur, List<String> ret) {
        if (left + right == n * 2) {
            ret.add(cur.toString());
            return;
        }

        if (left < n) {
            cur.append('(');
            DFS(n, left + 1, right, cur, ret);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (left > right) {
            cur.append(')');
            DFS(n, left, right + 1, cur, ret);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Generate_Parentheses().generateParenthesis(3));
    }
}
