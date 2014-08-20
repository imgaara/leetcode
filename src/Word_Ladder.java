import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by www.imgaara.com on 2014/8/20 0020.
 */
public class Word_Ladder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end)) {
            return 0;
        }

        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();

        HashSet<String> checked = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        q1.offer(start);
        int level = 2;

        while(!q1.isEmpty()){
            while(!q1.isEmpty()){
                String cur = q1.poll();
                if (sb.length() > 0) {
                    sb.delete(0, sb.length());
                }

                sb.append(cur);

                for (int i = 0; i < sb.length(); ++i) {
                    char origin = sb.charAt(i);
                    for (char x = 'a'; x <= 'z'; ++x) {
                        if (origin == x) {
                            continue;
                        } else {
                            sb.replace(i, i + 1, String.valueOf(x));
                            String target = sb.toString();
                            if (target.equals(end)) {
                                return level;
                            } else {
                                if (dict.contains(target) && !checked.contains(target)) {
                                    q2.offer(target);
                                    checked.add(target);
                                }
                            }
                        }
                    }

                    // recover
                    sb.replace(i, i + 1, String.valueOf(origin));
                }
            }

            Queue temp = q1;
            q1 = q2;
            q2 = temp;
            ++level;
        }

        return 0;
    }
}
