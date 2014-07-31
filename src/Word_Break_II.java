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

    public static void main(String[] args) {
        System.out.println(new Word_Break_II().wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }
}
