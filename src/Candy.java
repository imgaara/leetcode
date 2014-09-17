/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (null == ratings) {
            return 0;
        }

        int sum = ratings.length;
        int last = 1;
        for (int i = 0; i < ratings.length;) {
            if (i - 1 >= 0 && ratings[i] > ratings[i-1]) {
                last++;
            } else {
                last = 1;
            }

            int j = i + 1;
            for (; j < ratings.length && ratings[j-1] > ratings[j]; j++) {

            }

            if (j == i + 1) {
                sum += last - 1;
            } else {
                int calculatedByReverse = j - i;
                sum += (0 + calculatedByReverse - 1) * (j - i) / 2;
                if (last > calculatedByReverse) {
                    sum += (last - calculatedByReverse);
                }
                last = 1;
            }

            i = j;
        }

        return sum;
    }

    public int candy2(int[] ratings) {
        int[] incs = new int[ratings.length];

        for (int i = 1, inc = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i-1]) {
                incs[i] = inc++;
            } else {
                inc = 1;
            }
        }

        for (int i = ratings.length - 2, inc = 1; i >= 0; --i) {
            if (ratings[i] > ratings[i+1]) {
                incs[i] = Math.max(inc++, incs[i]);
            } else {
                inc = 1;
            }
        }

        int sum = ratings.length;
        for (int i = 0; i < incs.length; i++) {
            sum += incs[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{4,2,3,4,1}));
    }
}
