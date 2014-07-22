/**
 * Created by Administrator on 2014/7/22 0022.
 */
public class Sqrt_x {
    public int sqrt(int x) {
        if (x <= 1) {
            return x;
        } else {
            int i = 0;
            int j = x;
            while (i <= j) {
                int mid = (i+j) >>> 1;
                if ((double)mid*mid  > (double)x ) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }

            return j;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt_x().sqrt(2147483647));
    }
}
