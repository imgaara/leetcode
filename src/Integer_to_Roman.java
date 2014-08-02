import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/8/2 0002.
 */
public class Integer_to_Roman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(numerals[i]);
            }
        }

        return sb.toString();
    }

}
