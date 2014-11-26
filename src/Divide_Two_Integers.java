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
public class Divide_Two_Integers
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


    public int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long dividendL = dividend;
        long divisorL = divisor;

        boolean isNeg = false;
        if (dividendL < 0 && divisorL > 0 || dividendL > 0 && divisorL < 0) {
            isNeg = true;
        }

        dividendL = dividendL < 0 ? -dividendL : dividendL;
        divisorL = divisorL < 0 ? -divisorL : divisorL;

        int result = 0;
        while (dividendL >= divisorL) {
            int n = 0;
            long sum = divisorL << 1;
            while (sum <= dividendL) {
                n++;
                sum = sum << 1;
            }

            long sub = divisorL << n;
            dividendL -= sub;
            result += 1 << n;
        }

        return isNeg ? -result : result;
    }

    public static void main(String[] args)
    {
        System.out.println(new Divide_Two_Integers().divide(-2147483648, 1));
    }

}
