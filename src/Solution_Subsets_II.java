/**
 * 
 */

import java.util.*;

/**
 * @file	Solution_Subsets_II.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-7-13
 *
 * 
 */
public class Solution_Subsets_II
{
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (null == num || 0 == num.length) {
            return results;
        }
        
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetsWithDupDP_(num, 0, cur, results);
        return results;
    }
    
    private void subsetsWithDupDP_(int[] num, int start, List<Integer> cur, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(cur));
        
        for (int i = start; i < num.length; ++i) {
            if (i != start && num[i] == num[i-1]) {
                continue; // alreay sorted num array, here to remove duplicate result
            }
            
            cur.add(num[i]);
            subsetsWithDupDP_(num, i+1, cur, results);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Subsets_II().subsetsWithDup(new int[] {1,2,3,4,5,6,7,8,10,0}).size());
    }
}
