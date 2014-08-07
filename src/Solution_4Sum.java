import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @file	Solution_4Sum.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-14
 *
 * 
 */
public class Solution_4Sum
{
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
            int sum = list.get(i).sum + list.get(j).sum;
            if (sum == target) {
                if (list.get(i).first == list.get(j).first || list.get(i).second == list.get(j).second || list.get(i).first == list.get(j).second || list.get(i).second == list.get(j).first) {
                } else {
                    List<Integer> oooo = Arrays.asList(list.get(i).first, list.get(i).second, list.get(j).first, list.get(j).second);
                    Collections.sort(oooo);
                    String key = toStr(oooo.get(0), oooo.get(1), oooo.get(2), oooo.get(3));
                    if (!s.contains(key)) {
                        s.add(key);
                        r.add(Arrays.asList(num[oooo.get(0)], num[oooo.get(1)], num[oooo.get(2)], num[oooo.get(3)]));
                    }
                }
                
                if ( i + 1 < list.size() - 1 && list.get(i+1) == list.get(i)) {
                    i = i + 1;
                } else if ( j - 1 >= 0 && list.get(j-1) == list.get(j)) {
                    j = j - 1;
                } else {
                    i = i + 1;
                }
            } else if (sum > target) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        
        return r;
    }
    
    private String toStr(int i1, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(i1).append("-").append(i2).append("-").append(i3).append("-").append(i4);
        
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_4Sum().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }
}
