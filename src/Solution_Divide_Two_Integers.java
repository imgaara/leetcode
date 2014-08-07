/**
 * 
 */

/**
 * @file Solution_Divide_Two_Integers.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-6-18
 * 
 * 
 */
public class Solution_Divide_Two_Integers
{
    public int divide(int dividend, int divisor)
    {
        long dividendL = dividend;
        long divisorL = divisor;
        
        if (0 == divisorL) { return Integer.MAX_VALUE; }

        boolean isNeg = (dividendL > 0 && divisorL < 0 || dividendL < 0 && divisorL > 0);
        
        if (dividendL < 0)
        {
            dividendL = -dividendL;
        }

        if (divisorL < 0)
        {
            divisorL = -divisorL;
        }

        int result = 0;
        while (dividendL >= divisorL)
        {
            long subSum = divisorL;
            int subCount = 0;
            while (subSum <= dividendL)
            {
                subSum <<= 1;
                if (subSum > dividendL)
                {
                    break;
                }
                ++subCount;
            }

            subSum = divisorL << subCount;
            result += (1 << subCount);
            dividendL -= subSum;
        }

        return isNeg ? -result : result;
    }

    public static void main(String[] args)
    {
        System.out.println(new Solution_Divide_Two_Integers().divide(-2147483648, 2));
    }

}
