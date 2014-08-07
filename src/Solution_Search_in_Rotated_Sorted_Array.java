/**
 * 
 */

/**
 * @file	Solution_Search_in_Rotated_Sorted_Array.java
 * @package	
 * @project	ZTest
 * @author	Administrator
 * @time	2014-6-9
 *
 * 
 */
public class Solution_Search_in_Rotated_Sorted_Array
{
    public int search(int[] A, int target) {
        if (null == A) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        if (A[start] == target) {
            return start;
        }
        
        if (A[end] == target){
            return end;
        }

        if (A[start] >= A[end]) {
            if (target < A[start] && target > A[end]) {
                return -1; 
            } else if (target < A[end]) {
                int max = A[end];
                int i = start;
                int j = end;
                while (i <= j) {
                    int mid = (i + j) >>> 1;
                    if (A[mid] == target) {
                        return mid;
                    } else if (A[mid] > max){
                        i = mid + 1;
                    } else if (A[mid] == max && mid < j) {
                        i = mid + 1;
                    } else if (A[mid] > target) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
                
                return -1;
            } else if (target > A[start]) {
                int min = A[start];
                int i = start;
                int j = end;
                while (i <= j) {
                    int mid = (i + j) >>> 1;
                    if (A[mid] == target) {
                        return mid;
                    } else if (A[mid] < min){
                        j = mid - 1;
                    } else if (A[mid] == min && mid > i) {
                        j = mid - 1;
                    } else if (A[mid] > target) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
                
                return -1;
            } else {
                return -1;
            }
        } else {
            if (target < A[start] || target > A[end]) {
                return -1;
            }
            
            int i = start;
            int j = end;
            while (i <= j) {
                int mid = (i + j) >>> 1;
                if (A[mid] == target) {
                    return mid;
                } else if (A[mid] > target) {
                    j = mid - 1;
                } else if (A[mid] < target) {
                    i = mid + 1;
                }
            }
            
            return -1;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Solution_Search_in_Rotated_Sorted_Array().search(new int[] {1,1,3,1}, 3));
    }
    
}
