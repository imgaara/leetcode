/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Search_in_Rotated_Sorted_Array {
    public int search(int[] A, int target) {
        if (null == A) {
            return -1;
        }

        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            int cur = A[mid];
            if (cur == target) {
                return mid;
            } else if (A[i] <= cur) {
                if (A[j] <= target && target < cur) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (cur < target && target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }
}
