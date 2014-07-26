/**
 * Created by Administrator on 2014/7/26 0026.
 */
public class Next_Permutation {
    public void nextPermutation(int[] num) {
        int i = num.length - 2;
        int j = num.length - 1;
        boolean find = false;

        while (i >= 0) {
            if (num[i] < num[j]) {
                find = true;
                break;
            }
            --i;
            --j;
        }

        if (!find) {
            reverse_(num, 0, num.length - 1);
            return;
        }

        find = false;
        int k = num.length - 1;
        while (k >= 0) {
            if (num[i] < num[k]) {
                find = true;
                break;
            }
            --k;
        }

        if (!find) {
            reverse_(num, 0, num.length - 1);
            return;
        }

        int tmp = num[i];
        num[i] = num[k];
        num[k] = tmp;

        reverse_(num, j, num.length - 1);
        return;
    }

    private void reverse_(int[] num, int start, int end) {
        while (start < end) {
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
            ++start;
            --end;
        }
    }
}
