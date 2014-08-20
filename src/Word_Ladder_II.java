import java.util.*;

/**
 * Created by Administrator on 2014/8/20 0020.
 */
public class Word_Ladder_II {
    static class TraceInfo {
        int level;
        HashSet<String> track = new HashSet<String>();

        TraceInfo(int level) {
            this.level = level;
        }
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end,
                                                    HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (start.equals(end)) {
            return result;
        }

        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();

        Map<String, TraceInfo> checked = new HashMap<String, TraceInfo>();
        StringBuilder sb = new StringBuilder();
        q1.offer(start);
        boolean find = false;
        int level = 2;

        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
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
                                // here should continue to find all
                                if (checked.containsKey(cur)) {
                                    TraceInfo info = checked.get(cur);
                                    if (info.track.contains(target)) {
                                        continue;
                                    }
                                }
                                if (checked.containsKey(target)) {
                                    TraceInfo info = checked.get(target);
                                    info.track.add(cur);
                                } else {
                                    TraceInfo info = new TraceInfo(level);
                                    info.track.add(cur);
                                    checked.put(target, info);
                                }
                                find = true;
                            } else {
                                if (!dict.contains(target)) {
                                    continue;
                                } else {
                                    if (checked.containsKey(cur)) {
                                        TraceInfo info = checked.get(cur);
                                        if (info.track.contains(target)) {
                                            continue;
                                        }
                                    }

                                    if (checked.containsKey(target)) {
                                        TraceInfo info = checked.get(target);
                                        if (info.level != level) {
                                            continue;
                                        }

                                        info.track.add(cur);
                                    } else {
                                        TraceInfo info = new TraceInfo(level);
                                        info.track.add(cur);
                                        checked.put(target, info);

                                        q2.offer(target);
                                    }
                                }
                            }
                        }
                    }

                    // recover
                    sb.replace(i, i + 1, String.valueOf(origin));
                }
            }

            if (find) {
                break;
            }

            Queue temp = q1;
            q1 = q2;
            q2 = temp;
            ++level;
        }

        if (find) {
            return genResults(checked, start, end);
        } else {
            return result;
        }
    }

    private ArrayList<ArrayList<String>> genResults(
            Map<String, TraceInfo> checked, String start, String end) {
        ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();

        if (start.equals(end)) {
            r.add(new ArrayList<String>(Arrays.asList(start)));
            return r;
        }

        HashSet<String> track = checked.get(end).track;

        for (String curLast : track) {
            ArrayList<ArrayList<String>> subResult = genResults(checked, start,
                    curLast);
            for (ArrayList<String> subRoute : subResult) {
                r.add(subRoute);
            }
        }

        for (ArrayList<String> route: r) {
            route.add(end);
        }

        return r;
    }
}
