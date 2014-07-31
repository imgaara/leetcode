import java.util.Set;

/**
 * Created by Administrator on 2014/7/31 0031.
 */
public class Word_Break {
    public boolean wordBreak(String s, Set<String> dict) {
        // f(i) = f(k) && sub(k,i)
        // f(0) = true;
        int[] results = new int[s.length() + 1];
        return f(s, dict, s.length(), results);
    }

    public boolean f(String s, Set<String> dict, int index, int[] results) {
        if (0 == index) {
            return true;
        }

        if (results[index] != 0) {
            return results[index] == 1 ? true : false;
        }


        for (int k = index - 1; k >= 0; --k) {
            if (f(s, dict, k, results) && dict.contains(s.substring(k, index))) {
                results[index] = 1;
                return true;
            }
        }

        results[index] = 2;
        return false;
    }
}
