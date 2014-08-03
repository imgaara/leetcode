/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] A, int target) {
        if (null == A) {
            return false;
        }

        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            int cur = A[mid];
            if (cur == target) {
                return true;
            } else if (A[i] < cur) {
                if (A[i] <= target && target < cur) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (A[i] > cur) {
                if (cur < target && target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                i++;
            }
        }

        return false;
    }
}
