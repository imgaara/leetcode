/**
 * 
 */

import java.util.*;

/**
 * @file	Solution_Permutations_II.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-7-16
 *
 * 
 */
public class Solution_Permutations_II
{
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> curReuslt = new ArrayList<Integer>();
        Arrays.sort(num);
        permute_(num, 0, curReuslt, results);
        return results;
    }
    
    private void permute_(int[] num, int start, List<Integer> cur, List<List<Integer>> results) {
        if (start >= num.length) {
            results.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < num.length; ++i) {
            if (i != start && num[i] == num[start]) {
                continue;
            }
            
            swap(num, start, i);
            cur.add(num[start]);
            permute_(num, start + 1, cur, results);
            cur.remove(cur.size() - 1);
            swap(num, start, i);
        }
    }
    
    private void swap(int[] num, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Permutations_II().permuteUnique(new int[] {0,0,0,1,1,1,9}));
    }
}
