/**
 * Created by Administrator on 2014/12/8 0008.
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] num) {
        if (num.length == 0) {
            return -1;
        }
        int i = 0;
        int j = num.length - 1;

        while (i <= j) {
            if (i == j) {
                return i;
            }

            if (j - i == 1) {
                return num[i] > num[j] ? i : j;
            }

            int mid = (i + j) >>> 1;
            int left = mid == 0 ? Integer.MIN_VALUE : num[mid-1];
            int right = mid == num.length - 1 ? Integer.MIN_VALUE : num[mid+1];
            if (num[mid] > left && num[mid] > right) {
                return mid;
            } else if (num[mid] < left) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return j;
    }
}
