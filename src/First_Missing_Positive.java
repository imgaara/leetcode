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

    public int firstMissingPositive2(int[] A) {
        final int n = A.length;
        for (int i = 0; i < n; ++i) {
            while (A[i] != i + 1) {
                if (A[i] < 1 || A[i] > n || A[A[i]-1] == A[i]) {
                    break;
                }

                swap(A, i, A[i]-1);
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (A[i-1] != i) {
                return i;
            }
        }

        return n + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new First_Missing_Positive().firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
