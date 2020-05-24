package solution.solution_0203;

/**
 * @author shuai.yang
 */
public class RemoveElements {
    /**
     * 删除链表中等于给定值 val 的所有节点。
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
        // 1->2->6->3->4->5->6
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        int val = 1;
        System.out.println(removeElements(listNode, val));
    }

    /**
     * 第一思路: 遍历循环链表, 当碰到下一个值为规定的val时.跳过节点
     * 问题: 当规定的值在链表头部时步方便处理
     * 采用哨兵节点. 在链表的头部放置一个哨兵节点,保证链表头部永远不是规定的val
     * 最后next取出结果即可
     * */
    private static ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode temp = header;
        while (header != null) {
            if (header.next != null && header.next.val == val) {
                // 移除
                header.next = header.next.next;
            } else {
                header = header.next;
            }
        }
        return temp.next;
    }
}
