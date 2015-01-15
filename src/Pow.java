/**
 * Created by www.imgaara.com on 2015/1/15 0015.
 */
public class Pow {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / pow(x, -(n+1)) / x;
            } else {
                return 1.0 / pow(x, -n);
            }
        }

        double y = pow(x, n/2);
        if (n % 2 == 1) {
            return y * y * x;
        } else {
            return y * y;
        }
    }
}
