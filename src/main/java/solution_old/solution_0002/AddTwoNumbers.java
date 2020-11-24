package solution_old.solution_0002;

/**
 * @author shuai.yang
 */
public class AddTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
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
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(6);
        l4.next = l5;
        l5.next = l6;

        printList(addTwoNumbers(l1, l4));
    }

    /**
     * 定义一个新的链表用于保存结果
     * 循环两个链表. 不为null就记录val值. 进行相加. 如果超过10就记录进位1
     * 下次循环对进位1相加
     * 如果循环退出依然有进位
     * 那么在最后新增节点
     * */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;

        int n = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + n;
            n = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (n > 0) {
            temp.next = new ListNode(n);
        }
        return listNode.next;
    }

    private static void printList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }
}
