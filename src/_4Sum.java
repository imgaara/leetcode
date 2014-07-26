import java.util.*;

/**
 * Created by Administrator on 2014/7/26 0026.
 */
public class _4Sum {
    static class Helper {
        int first;
        int second;
        int sum;

        public Helper(int f, int s, int[] num) {
            first = f;
            second = s;
            sum = num[first] + num[second];
        }

    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();

        if (null == num || num.length < 4) {
            return r;
        }

        Set<String> s = new HashSet<String>();
        Arrays.sort(num);

        List<Helper> list = new ArrayList<Helper>();
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1; j < num.length; ++j) {
                list.add(new Helper(i, j, num));
            }
        }

        Collections.sort(list, new Comparator<Helper>() {
            @Override
            public int compare(Helper lhs, Helper rhs) {
                if (lhs.sum < rhs.sum) {
                    return -1;
                } else if (lhs.sum > rhs.sum) {
                    return 1;
                } else return 0;
            }
        });

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int ii = i;
            int jj = j;
            int sum = list.get(i).sum + list.get(j).sum;;
            for (; ii < j && list.get(ii).sum == list.get(i).sum; ++ii) {
                jj = j;
                for (; jj > ii && list.get(jj).sum == list.get(j).sum; --jj) {
                    if (sum == target) {
                        if (list.get(ii).first == list.get(jj).first || list.get(ii).second == list.get(jj).second || list.get(ii).first == list.get(jj).second || list.get(ii).second == list.get(jj).first) {
                            continue;
                        }

                        List<Integer> oooo = Arrays.asList(num[list.get(ii).first], num[list.get(ii).second], num[list.get(jj).first], num[list.get(jj).second]);
                        Collections.sort(oooo);
                        String key = toStr(oooo.get(0), oooo.get(1), oooo.get(2), oooo.get(3));
                        if (!s.contains(key)) {
                            s.add(key);
                            r.add(oooo);
                        }
                    }
                }
            }

            if (sum == target) {
                i = ii;
                j = jj;
            } else if (sum > target) {
                j = jj;
            } else {
                i = ii;
            }
        }

        return r;
    }

    private String toStr(int i1, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(i1).append("-").append(i2).append("-").append(i3).append("-").append(i4);

        return sb.toString();
    }
}
