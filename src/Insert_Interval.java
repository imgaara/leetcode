import util.Interval;

import java.util.*;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Insert_Interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        int i = 0;
        int j = intervals.size() - 1;

        int find = -1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            Interval cur = intervals.get(mid);
            if (cur.start == newInterval.start) {
                find = mid;
                break;
            } else if (cur.start > newInterval.start){
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        if (find == -1) {
            find = j;
        }

        List<Interval> result = new ArrayList<Interval>();

        for (int k = 0; k <= find; k++) {
            result.add(intervals.get(k));
        }

        if (result.size() > 0) {
            Interval last = result.get(result.size() - 1);
            if (newInterval.start > last.end) {
                result.add(newInterval);
            } else {
                last.end = Math.max(last.end, newInterval.end);
            }
        } else {
            result.add(newInterval);
        }

        for (int k = find + 1; k < intervals.size(); k++) {
            Interval last = result.get(result.size() - 1);
            Interval cur = intervals.get(k);
            if (cur.start > last.end) {
                result.add(cur);
            } else {
                last.end = Math.max(last.end, cur.end);
            }
        }

        return result;
    }

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        Iterator<Interval> it = intervals.iterator();
        while (it.hasNext()) {
            Interval cur = it.next();
            if (cur.start > newInterval.end) {
                intervals.add(newInterval);
            }
        }

        return intervals;
    }

    public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
        for (int i = 0; i < intervals.size(); ++i) {
            Interval cur = intervals.get(i);
            if (newInterval.end < cur.start) {
                intervals.add(i, newInterval);
                return intervals;
            } else if (newInterval.start > cur.end) {
                continue;
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
                intervals.remove(i);
                i--;
            }
        }

        intervals.add(newInterval);
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0,4), new Interval(7, 12));
        System.out.println(new Insert_Interval().insert(intervals, new Interval(0,5)));
    }
}
