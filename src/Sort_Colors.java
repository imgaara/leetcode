/**
 * Created by Administrator on 2014/8/14 0014.
 */
public class Sort_Colors {
    public void sortColors(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int cur = 0;

        while (cur < A.length) {
            if (A[cur] == 0) {
                if (cur > start) {
                    swap(A, start++, cur);
                } else{
                    ++cur;
                }
            } else if (A[cur] == 2) {
                if (cur < end) {
                    swap(A, end--, cur);
                } else {
                    ++cur;
                }
            } else {
                ++cur;
            }
        }
    }

    private void swap(int[] A, int pos1, int pos2) {
        int temp = A[pos1];
        A[pos1] = A[pos2];
        A[pos2] = temp;
    }
}
