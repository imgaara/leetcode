import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2015/1/15 0015.
 */
public class Largest_Number {
    public String largestNumber(int[] num) {
        if (num.length == 0) {
            return "0";
        }

        String[] temp = new String[num.length];
        for (int i = 0; i < num.length; ++i) {
            temp[i] = String.valueOf(num[i]);
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        boolean hasNoneZero = false;
        for (int i = temp.length - 1; i >= 0; --i) {
            if (!temp[i].equals("0")) {
                sb.append(temp[i]);
                hasNoneZero = true;
            } else if(hasNoneZero) {
                sb.append(temp[i]);
            }

        }

        if (!hasNoneZero) {
            sb.append('0');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Largest_Number().largestNumber(new int[]{121,12}));
        System.out.println(new Largest_Number().largestNumber(new int[]{0, 0}));

    }
}
