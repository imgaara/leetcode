import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2014/12/9 0009.
 */
public class Simplify_Path {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Deque<String> s = new LinkedList<String>();
        s.addLast("/");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (s.size() > 1) {
                    s.pollLast();
                }
            } else {
                s.addLast(token);
            }
        }

        if (s.size() <= 1) {
            return "/";
        }

        s.pollFirst();
        StringBuilder sb = new StringBuilder();
        while (s.size() != 0) {
            sb.append("/").append(s.pollFirst());
        }
        return sb.toString();
    }
}
