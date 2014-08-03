/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if ((total & 0x1) > 0) {
            return findK(A, 0, A.length, B, 0, B.length, total / 2 + 1);
        } else {
            int m1 = findK(A, 0, A.length, B, 0, B.length, total / 2);
            int m2 = findK(A, 0, A.length, B, 0, B.length, total / 2 + 1);
            return  (m1 + m2) / 2.0f;
        }
    }

    private int findK(int A[], int startA, int lenA, int B[], int startB, int lenB, int k) {
        if (lenA > lenB) {
            return findK(B, startB, lenB, A, startA, lenA, k);
        }

        if (lenA == 0) {
            return B[startB + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        int ka = Math.min(k/2, lenA);
        int kb = k - ka;
        if (A[startA + ka -1] < B[startB + kb - 1]) {
            return findK(A, startA + ka, lenA - ka, B, startB, lenB, k - ka);
        } else if (A[startA + ka - 1] > B[startB + kb - 1]) {
            return findK(A, startA, lenA, B, startB + kb, lenB - kb, k - kb);
        } else {
            return A[startA + ka - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Median_of_Two_Sorted_Arrays().findMedianSortedArrays(new int[]{1,2}, new int[]{1,2}));
    }
}
