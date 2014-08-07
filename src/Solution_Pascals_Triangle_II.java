import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 */

/**
 * @file	Solution_Pascals_Triangle_II.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-20
 *
 * 
 */
public class Solution_Pascals_Triangle_II
{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new LinkedList<Integer>();
        r.add(1);
        
        if (rowIndex == 1) {
            return r;
        }
        
        r.add(2);
        r.add(1);
        if (rowIndex == 2) {
            return r;
        }
        
        for (int i = 3; i <= rowIndex; ++i) {
            r.add(0, 1);
            ListIterator<Integer> it2 = r.listIterator();
            ListIterator<Integer> it3 = r.listIterator();
            it2.next();
            it3.next();
            it3.next();
            
            while (it3.hasNext()) {
                int val = it2.next() + it3.next();
                it2.set(val);
            }
        }
        
        return r;
    }
    
    private int C(int r, int n) {
        if (0 == r) {
            return 1;
        }
        
        return (int) (fa(n)/fa(r)/fa(n-r));
    }
    
    private long fa(int n) {
        long s = 1;
        for (int i = 1; i <= n; ++i) {
            s *= i;
        }
        
        return s;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Pascals_Triangle_II().getRow(4));
    }
}
