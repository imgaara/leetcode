/**
 * Created by Administrator on 2014/12/8 0008.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] num) {
        if (num.length == 0) {
            return -1;
        }

        if (num.length == 1) {
            return num[0];
        }

        int i = 0;
        int j = num.length - 1;
        while (i <= j) {
            int mid = (i+j) >>>1;
            if (num[i] < num[j]) {
                return num[i];
            } else if (num[i] > num[j]) {
                if (num[i] <= num[mid]){
                    i = mid + 1;
                } else if (num[mid] <= num[j]) {
                    if (num[mid] <= num[mid+1] && num[mid] < num[mid - 1]) {
                        return num[mid];
                    } else {
                        j = mid - 1;
                    }
                }
            } else {
                i++;
            }
        }

        return num[j];
    }

    public static void main(String[] args) {
        System.out.println(new Find_Minimum_in_Rotated_Sorted_Array_II().findMin(new int[]{3, 1, 1}));
    }
}
