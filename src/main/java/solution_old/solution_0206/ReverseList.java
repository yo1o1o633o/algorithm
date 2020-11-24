package solution_old.solution_0206;

public class ReverseList {
    /**
     * 反转一个单链表。
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
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(reverseList(listNode));
        System.out.println(reverseList2(listNode));
    }

    /**
     * 定义一个新的链表头prev
     * 每次将后一个取出,并把next指向prev
     * 1->2->3->4->5
     * 1->null  prev = 1->null
     * 2->3->4->5
     * 2->null  prev = 2->1->null
     * ...
     * */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    /**
     * 题解: 递归
     * 传递下去. 一直到最后一个节点. 然后回归将最后一个节点指向前一个节点
     * head.next 切断原有链表的关联
     *
     * 最后一次递归
     * 4.next.next -> 5   4.next -> null
     *
     * */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
