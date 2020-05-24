package solution.solution_0237;

/**
 * @author shuai.yang
 */
public class DeleteNode {
    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
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
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        deleteNode(l2);
        System.out.println(1);
    }

    /**
     * 直接在给定的节点进行操作
     * 删除node节点的值
     * 那么即是移除这个节点, 而现在获取不到前一个节点.
     * 所以将后一个节点的值赋给要删除的节点. 此时节点的值已经完成
     * 然后再将指针向后跳过一个节点
     * 例如4->5->1->9
     * 要删除5节点
     * 那么先修改5的值val=1.
     * 变成了4->1->1->9
     * 此时1的值已经前移, 那么原来的1节点就不需要了. 将指针向后跳过指向9节点
     * */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
