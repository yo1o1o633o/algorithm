package solution_old.solution_0142;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class DetectCycle {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     * */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode add1 = new ListNode(2);
        listNode.next = add1;
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = add1;
        System.out.println(detectCycle(listNode));
        System.out.println(detectCycle2(listNode));
    }

    /**
     * 和判断环一样. HashSet来一波.
     * */
    private static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 双指针
     * 先找到环中的相遇点. 注意: 相遇点不是入环点. 因为有可能在环的中间相遇了
     * 要记录链表头和相遇点
     * 当链表头和相遇点相同时就是入环点
     * */
    private static ListNode detectCycle2(ListNode head) {
        ListNode headCopy = head;
        ListNode hard = helper(head);
        if (hard == null) {
            return null;
        }
        while (headCopy != hard) {
            headCopy = headCopy.next;
            hard = hard.next;
        }
        return headCopy;
    }
    private static ListNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode hard = head;
        while (fast != null && fast.next != null) {
            hard = hard.next;
            fast = fast.next.next;
            if (hard == fast) {
                return hard;
            }
        }
        return null;
    }
}
