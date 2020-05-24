package solution.solution_0083;

/**
 * @author Yang
 */
public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        listNode1.next.next.next = new ListNode(3);
        ListNode res = deleteDuplicates(head);
    }

    /**
     * 遇到重复就将后一个赋值给前一个.
     * 指向的是同一个内存地址, head保存的是头指针. 对temp操作就会影响head
     * */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
