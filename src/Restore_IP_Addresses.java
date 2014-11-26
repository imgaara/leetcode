import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/21 0021.
 */
public class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> cur = new ArrayList<String>();
        DFS(s, 0, cur, result);
        return result;
    }

    private void DFS(String s, int start, List<String> cur, List<String> result) {
        if (start >= s.length()) {
            if (cur.size() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append(cur.get(0));
                for (int i = 1 ; i < 4; i++) {
                    sb.append('.').append(cur.get(i));
                }
                result.add(sb.toString());
            }
        }

        if (cur.size() == 4) {
            return;
        }

        for (int i = start + 1; i <= s.length() && (i - start) < 4; ++i) {
            String substr = s.substring(start, i);
            if (substr.length() > 1) {
                if (substr.startsWith("0")) {
                    continue;
                }
            }

            Integer intAddr = Integer.valueOf(substr);

            if (intAddr <= 255) {
                cur.add(substr);
                DFS(s, i, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
