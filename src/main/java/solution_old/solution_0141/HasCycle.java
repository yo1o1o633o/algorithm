package solution_old.solution_0141;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class HasCycle {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
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
        System.out.println(hasCycle(listNode));
        System.out.println(hasCycle1(listNode));
    }

    /***
     * set集合. 循环将当前节点对象放入set中. 当发现set中已存在. 即表示有环
     * 只要有环肯定会有重复出现
     * 否则无环肯定会有next为null情况出现
     */
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * 快指针每次跳两步
     * 慢指针每次跳一步
     * 如果有环,那么快慢指针一定会相遇的.
     * */
    private static boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        while (head != null && fast != null && fast.next != null) {
            if (head == fast) {
                return true;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return false;
    }
}
