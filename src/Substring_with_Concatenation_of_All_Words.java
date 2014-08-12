import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

 For example, given:
 S: "barfoothefoobarman"
 L: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 * @author www.imgaara.com on 2014/7/27 0027.
 */
public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> r = new ArrayList<Integer>();

        if (null == S || null == L || L.length == 0) {
            return r;
        }

        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        int len = L[0].length();
        int totalLen = len * L.length;

        for (String l : L) {
            Integer count = wordCount.get(l);
            if (null == count) {
                wordCount.put(l, 1);
            } else {
                // should ask whether the words in L is unique
                wordCount.put(l, count+1);
            }
        }

        for (int i = 0; i <= S.length() - totalLen; ++i) {
            Map<String, Integer> tempMap = new HashMap<String, Integer>(wordCount);
            int count = L.length;
            for (int j = i; j <= S.length() - len && count > 0; j+=len, count--) {
                String cur = S.substring(j, j + len);
                Integer curNumber = tempMap.get(cur);
                if (null == curNumber) {
                    break;
                } else {
                    if (curNumber <= 0) {
                        break;
                    }
                    tempMap.put(cur, curNumber - 1);
                }
            }

            if (count == 0) {
                r.add(i);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Substring_with_Concatenation_of_All_Words().findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
    }
}
