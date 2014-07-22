/**
 * Created by Administrator on 2014/7/22 0022.
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] A) {
        for (int curIdx = 0; curIdx < A.length;) {
            int cur = A[curIdx];
            int toIdx = cur - 1;
            if (curIdx == toIdx) {
                ++curIdx;
            } else {
                if (toIdx >= 0 && toIdx < A.length) {
                    int temp = A[toIdx];
                    A[toIdx] = cur;
                    A[curIdx] = temp;
                    continue;
                } else {
                    ++curIdx;
                }
            }
        }

        for (int curIdx = 0; curIdx < A.length; ++curIdx) {
            if (A[curIdx] != curIdx + 1) {
                return curIdx + 1;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new First_Missing_Positive().firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
