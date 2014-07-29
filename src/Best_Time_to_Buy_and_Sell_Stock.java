/**
 * Created by Administrator on 2014/7/29 0029.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i-1] < min) {
                min = prices[i-1];
            }

            int profit = prices[i] - min;
            if (profit > max) {
                max = profit;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(new int[] {2,1,2,0,1}));
    }
}
