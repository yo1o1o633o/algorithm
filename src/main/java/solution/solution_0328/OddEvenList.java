package solution.solution_0328;

/**
 * @author shuai.yang
 */
public class OddEvenList {
    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        printList(oddEvenList(l1));
    }

    /**
     * 拆分奇数和偶数
     * 偶数链表从第二个节点开始
     * odd 和 head 都指向了 486内存地址
     * 此时做next赋值后. odd 和 head 的下一个节点会指向488内存地址跳过487内存地址. 也就是487内存地址没有变化
     * evenTemp保存了487内存地址.
     * 而even和evenTemp都指向了487内存地址. 同时发送变化
     * 最终head变成只有奇数的链表   even变成只有偶数的链表
     * */
    private static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        // 保存了下一个节点.
        ListNode evenTemp = head.next;
        ListNode even = evenTemp;
        while (odd.next != null && evenTemp.next != null) {
            odd.next = odd.next.next;
            evenTemp.next = evenTemp.next.next;
            odd = odd.next;
            evenTemp = evenTemp.next;
        }
        odd.next = even;
        return head;
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
