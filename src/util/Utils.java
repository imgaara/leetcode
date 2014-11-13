package util;

import java.util.*;

/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Utils {
    public static void printList(ListNode head) {
        while (null != head) {
            System.out.print(head.val);
            System.out.print(',');
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode genList(int needNum) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;
        for (int i = 1; i < needNum; ++i) {
            tail.next = new ListNode(i, null);
            tail = tail.next;
        }

        return head;
    }

    public static ListNode genList(int ... args) {
        assert(args.length > 0);
        ListNode head = new ListNode(args[0], null);
        ListNode tail = head;
        for (int i = 1; i < args.length; ++i) {
            tail.next = new ListNode(args[i], null);
            tail = tail.next;
        }

        return head;
    }

    public static void print2DCharArray(char[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    public static char[][] strArrayTo2DArray(String[] strs) {
        char[][] array = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; ++i) {
            array[i] = strs[i].toCharArray();
        }

        return array;
    }

    public static <T> void printListList(List<List<T>> list) {
        for (List<?> l : list) {
            System.out.println(l);
        }
    }

    public static TreeNode generateTree(String ... ss) {
        String[] s = new String[ss.length + 1];
        System.arraycopy(ss, 0, s, 1, ss.length);

        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

        for (int i = 1; i < s.length; ++i) {
            int left = i * 2;
            int right = i * 2 + 1;
            TreeNode root = map.get(i);
            if (null == root) {
                root = new TreeNode(Integer.valueOf(s[i]));
                map.put(i, root);
            }

            if (left < s.length) {
                TreeNode node = map.get(left);
                if (null == node) {
                    String cur = s[left];
                    node = cur.equals("#") ? null : new TreeNode(Integer.valueOf(cur));
                    map.put(left, node);
                }

                root.left = node;
            }

            if (right < s.length) {
                TreeNode node = map.get(right);
                if (null == node) {
                    String cur = s[right];
                    node = cur.equals("#") ? null : new TreeNode(Integer.valueOf(cur));
                    map.put(right, node);
                }

                root.right = node;
            }
        }

        return map.get(1);
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(Utils.gcd(3, 12));
    }
}
