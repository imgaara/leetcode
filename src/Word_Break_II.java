import java.util.*;

/**
 * Created by Administrator on 2014/7/31 0031.
 */
public class Word_Break_II {
    public List<String> wordBreak(String s, Set<String> dict) {
        // f(i) = f(k) && sub(k,i)
        // f(0) = true;

        List<String> result = new ArrayList<String>();
        List<String> cur = new ArrayList<String>();
        int[] results = new int[s.length() + 1];
        f(s, dict, s.length(), results, cur, result);
        return result;
    }

    public void f(String s, Set<String> dict, int index, int[] results, List<String> cur, List<String> result) {
        if (0 == index) {
            StringBuilder sb = new StringBuilder();
            for (int i = cur.size() - 1; i >= 0; i--) {
                sb.append(cur.get(i)).append(' ');
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            result.add(sb.toString());
            return;
        }

        for (int k = index - 1; k >= 0; --k) {
            String subStr = s.substring(k, index);
            if (dict.contains(subStr)) {
                cur.add(subStr);
                f(s, dict, k, results, cur, result);
                results[index] = 1;
                cur.remove(cur.size() - 1);
            }
        }

        results[index] = 2;
    }

    public List<String> wordBreak2(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        boolean[][] isWord = new boolean[s.length() + 1][s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                String substr = s.substring(j, i);
                if (canBreak[j] && dict.contains(substr)) {
                    canBreak[i] = true;
                    isWord[j][i] = true;
                }
            }
        }

        List<String> ret = new ArrayList<String>();
        List<String> buff = new ArrayList<String>();
        genPath(s, s.length(), buff, ret, isWord, canBreak);
        return ret;
    }

    private void genPath(String s, int end, List<String> buff, List<String> ret, boolean[][] isWord, boolean[] canBreak) {
        if (end <= 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < buff.size(); ++i) {
                sb.append(buff.get(buff.size() - 1 - i)).append(' ');
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            ret.add(sb.toString());
            return;
        }

        if (!canBreak[end]) {
            return;
        }

        for (int i = end - 1; i >= 0; --i) {
            if (isWord[i][end]) {
                buff.add(s.substring(i, end));
                genPath(s, i, buff, ret, isWord, canBreak);
                buff.remove(buff.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Word_Break_II().wordBreak2("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }
}
