/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class ZigZag_Conversion {
    public String convert(String s, int nRows) {
        if (null == s || nRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int dep = nRows * 2 - 2;
        for (int row = 0; row < nRows; ++ row) {
            for (int start = 0; start < s.length() + dep; start+=dep) {
                if (row == 0 || row == nRows - 1) {
                    int pos = start + row;
                    if (pos < s.length()) {
                        sb.append(s.charAt(pos));
                    }
                } else {
                    int pos1 = start - row;
                    int pos2 = start + row;
                    if (pos1 >= 0 && pos1 < s.length()) {
                        sb.append(s.charAt(pos1));
                    }

                    if (pos2 < s.length()) {
                        sb.append(s.charAt(pos2));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZag_Conversion().convert("PAHNAPLSIIGYIR", 3));
        System.out.println(new ZigZag_Conversion().convert("PAHNAPLSIIGYIR", 1));
        System.out.println(new ZigZag_Conversion().convert("PAHNAPLSIIGYIR", 2));
    }
}
