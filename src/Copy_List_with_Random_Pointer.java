import util.RandomListNode;

/**
 * Created by Administrator on 2014/7/21 0021.
 */
public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        while (null != p) {
            RandomListNode next = p.next;
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = next;
            p.next = newNode;
            p = next;
        }

        p = head;
        while (null != p) {
            RandomListNode newNode = p.next;
            RandomListNode next = newNode.next;
            if (null != p.random) {
                newNode.random = p.random.next;
            }
            p = next;
        }

        p = head;
        RandomListNode clone = null;
        RandomListNode tail = null;
        while (null != p) {
            RandomListNode newNode = p.next;
            RandomListNode next = newNode.next;

            p.next = next;
            newNode.next = null;

            if (null == clone) {
                clone = newNode;
                tail = clone;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }

            p = next;
        }

        return clone;
    }
}
