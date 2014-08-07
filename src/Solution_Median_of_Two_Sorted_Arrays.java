import java.util.Arrays;

/**
 * 
 */

/**
 * @file Solution_Median_of_Two_Sorted_Arrays.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-7-8
 * 
 * 
 */
public class Solution_Median_of_Two_Sorted_Arrays
{
    public double findMedianSortedArrays(int A[], int B[])
    {
        if (null == A || null == B || (A.length == 0 && B.length == 0)) {
            return 0;
        }
        
        if (A.length == B.length) {
            if (A[A.length - 1] <= B[0]) {
                return median(A[A.length - 1], B[0]);
            } else if (A[0] >= B[B.length - 1]) {
                return median(A[0], B[B.length -1]);
            }
        }
        
        final int K = A.length + B.length;
        final boolean isOdd = K % 2 == 1;
        final int half = isOdd ? ((K+1)/2 - 1): (K/2 - 1);
        
        int i1 = 0;
        int i2 = 0;
        int j1 = A.length - 1;
        int j2 = B.length - 1;
        
        int mid1 = 0;
        int mid2 = 0;
        while (i1 <= j1 && i2 <= j2) {
            mid1 =  (i1 + j1) >>> 1;
            int left1 = mid1 - 0;
            mid2 = findPos_(B, i2, j2, A[mid1]);
            
            int left2 = mid2 - 0;
            
            if (left1 + left2 == half) {
                if (isOdd) {
                    return A[mid1];
                } else {
                    if (mid1 < A.length -1) {
                        return median(A[mid1], A[mid1 + 1], B[mid2]);
                    } else {
                        return median(A[mid1], B[mid2]);
                    }
                }
            } else if (left1 + left2 > half) {
                j2 = mid2;
                j1 = mid1 - 1;
            } else {
                i2 = mid2;
                i1 = mid1 + 1;
            }
        }
        
        mid1 =  (i1 + j1) >>> 1;
        while (i1 <= j1) {
            mid1 =  (i1 + j1) >>> 1;
            int left1 = mid1 - 0;
            int left2 = mid2 - 0;
            
            if (left1 + left2 == half) {
                if (isOdd) {
                    return A[mid1];
                } else {
                    if (B.length == 0) {
                        return median(A[mid1], A[mid1+1]);
                    }
                    
                    if (mid1 < A.length -1) {
                        return median(A[mid1], A[mid1 + 1], B[mid2]);
                    } else {
                        return median(A[mid1], B[mid2]);
                    }
                }
            } else if (left1 + left2 > half) {
                j1 = mid1 - 1;
            } else {
                i1 = mid1 + 1;
            }
        }
        
        while (i2 <= j2) {
            mid2 =  (i2 + j2) >>> 1;
            int left1 = mid1 - 0;
            int left2 = mid2 - 0;
            
            if (left1 + left2 == half) {
                if (isOdd) {
                    return B[mid2];
                } else {
                    if (A.length == 0) {
                        return median(B[mid2], B[mid2+1]);
                    }
                    
                    if (mid2 < B.length -1) {
                        return median(B[mid2], B[mid2 + 1], A[mid1]);
                    } else {
                        return median(A[mid1], B[mid2]);
                    }
                }
            } else if (left1 + left2 > half) {
                j2 = mid2 - 1;
            } else {
                i2 = mid2 + 1;
            }
        }
        
        return 0;
    }
    
    private int findPos_(int[] x, int start, int end, int target) {
        int i = 0;
        int j = end;
        
        while (i <= j) {
            int mid = (i+j) >>> 1;
            if (mid == target) {
                return mid;
            } else if (target > x[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return i;
    }
    
    private double median(int a1, int a2, int a3) {
        int[] aa = new int[3];
        aa[0] = a1;
        aa[1] = a2;
        aa[2] = a3;
        Arrays.sort(aa);
        return ((double)aa[0] + (double)aa[1]) / 2;
    }
    
    private double median(int a1, int a2) {
        return ((double)a1 + (double)a2) / 2;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(new int[] {1}, new int[] {2,3}));
    }
}
