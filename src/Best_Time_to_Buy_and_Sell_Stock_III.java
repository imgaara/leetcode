import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * find max in 0...i and i+1...n
 * Created by Administrator on 2014/7/29 0029.
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int minLeft = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i-1] < minLeft) {
                minLeft = prices[i-1];
            }

            int profit = prices[i] - minLeft;
            if (profit > max) {
                max = profit;
            }

            left[i] = max;
        }

        int maxRight = 0;
        max = 0;
        for (int i = prices.length - 2; i > 0; --i) {
            if (prices[i+1] > maxRight) {
                maxRight = prices[i+1];
            }

            int profit = maxRight - prices[i];
            if (profit > max) {
                max = profit;
            }
            right[i] = max;
        }

        max = 0;
        for (int i = 1; i < prices.length; ++i) {
            int cur = left[i];
            if (i + 1 < prices.length) {
                cur += right[i+1];
            }
            if (cur > max) {
                max = cur;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
