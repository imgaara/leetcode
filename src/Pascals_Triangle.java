import util.Utils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();

        if (numRows <= 0) {
            return r;
        }

        List<Integer> r1 = new ArrayList<Integer>();
        r1.add(1);
        r.add(r1);
        if (numRows == 1) {
            return r;
        }

        List<Integer> r2 = new ArrayList<Integer>();
        r2.add(1);
        r2.add(1);
        r.add(r2);
        if (numRows == 2) {
            return r;
        }

        for (int i = 2; i < numRows; ++i) {
            List<Integer> ri = new ArrayList<Integer>();
            List<Integer> last = r.get(i - 1);
            ri.add(1);
            for (int j = 1; j < i; ++j) {
                ri.add(last.get(j-1) + last.get(j));
            }
            ri.add(1);
            r.add(ri);
        }

        return r;
    }

    public static void main(String[] args) {
        Utils.printListList(new Pascals_Triangle().generate(1));
        Utils.printListList(new Pascals_Triangle().generate(2));
        Utils.printListList(new Pascals_Triangle().generate(3));
        Utils.printListList(new Pascals_Triangle().generate(4));
    }
}
