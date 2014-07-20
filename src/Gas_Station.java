/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPos = gas.length - 1;
        int curTank = 0;
        int lastTo = gas.length - 1;
        for (int tryTimes = 0; tryTimes < gas.length; ++tryTimes) {
            startPos = gas.length - 1 - tryTimes;
            curTank += gas[startPos] - cost[startPos];
            if (curTank >= 0) {
                int curPos = (lastTo + 1) % gas.length;
                while (curPos != startPos) {
                    curTank += gas[curPos] - cost[curPos];
                    if (curTank < 0) {
                        lastTo = curPos;
                        break;
                    }
                    curPos = (curPos + 1) % gas.length;
                }

                if (curTank >= 0) {
                    return startPos;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Gas_Station().canCompleteCircuit(new int[]{1,2,3,3}, new int[]{2,1,5,1}));
        System.out.println(new Gas_Station().canCompleteCircuit(new int[]{2,3,1}, new int[]{3,1,2}));
    }
}
