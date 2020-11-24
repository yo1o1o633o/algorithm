package solution_old.solution_0019;

/**
 * @author shuai.yang
 */
public class RemoveNthFromEnd {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
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
        int n = 2;
        System.out.println(removeNthFromEnd(listNode, n));
        System.out.println(removeNthFromEnd1(listNode, n));
    }

    /**
     * 两次遍历
     * */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int num = 0;
        while (head != null) {
            num++;
            head = head.next;
        }
        int index = num - n;
        // temp和dummy引用的同一个内存地址. 一个变化另一个也变化
        ListNode temp = dummy;
        while (index > 0) {
            index--;
            // 此处不会改动dummy. 因为是相当于对temp重新赋值
            temp = temp.next;
        }
        // 此处改动会影响dummy. 因为是对temp的内部变量的值进行修改.而temp和dummy引用的同一个地址.
        temp.next = temp.next.next;
        return dummy.next;
    }

    /**
     * 一次遍历
     * 双指针. 慢指针每次一步. 快指针n+1步
     * 维持两个指针间隔n个间隔
     * 假设快指针到达最后一个节点时. 那么慢指针就到达了要删除的节点
     * */
    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
