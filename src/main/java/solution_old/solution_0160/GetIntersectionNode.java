package solution_old.solution_0160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class GetIntersectionNode {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
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
        ListNode inter = new ListNode(8);
        inter.next = new ListNode(4);
        inter.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = inter;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = inter;

        System.out.println(getIntersectionNode(headA, headB));
        System.out.println(getIntersectionNode2(headA, headB));
    }

    /**
     * Hash表. 将A的节点都放入Hash表中
     * 再遍历B的节点. 发现存在的即时相交的节点
     * */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针
     * 错的人迟早会走散, 而对的人早晚会相逢
     *
     * 当其中一个链表执行完后, 把他的next指向另一个链表的头部
     * */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }
}
