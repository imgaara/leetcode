import util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        List<Interval> result = new ArrayList<Interval>();

        for (int i = 0; i < intervals.size();) {
            Interval v1 = intervals.get(i);

            // find and merge
            int j = i + 1;
            for (; j < intervals.size(); ++j) {
                Interval v2 = intervals.get(j);
                if (v2.start > v1.end) {
                    break;
                } else {
                    int maxEnd = Math.max(v2.end, v1.end);
                    v1.end = maxEnd;
                }
            }

            // add merged result
            result.add(new Interval(v1.start, v1.end));
            i = j;
        }

        return result;
    }
}
