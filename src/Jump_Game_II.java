/**
 * Created by Administrator on 2014/8/24 0024.
 */
public class Jump_Game_II {
    public int jump(int[] A) {
        if (null == A || A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }

        int count = 1;
        int farPos = A[0];
        int nextFarPos = 0;
        int cur = 1;

        while (cur < A.length) {
            while (cur <= farPos && cur < A.length) {
                if (A[cur] + cur > nextFarPos) {
                    nextFarPos = A[cur] + cur;
                }
                ++cur;
            }

            if (cur == A.length) {
                break;
            } else {
                if (nextFarPos > farPos) {
                    farPos = nextFarPos;
                    ++count;
                } else {
                    return -1;
                }
            }
        }

        return count;
    }
}
