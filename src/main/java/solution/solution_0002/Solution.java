package solution.solution_0002;

import entity.ListNode;
import utils.ListNodeUtils;

/**
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        ListNodeUtils.printList(addTwoNumbers(l1, l2));
    }

    /**
     * 循环取出列表头节点进行计算， 组装成新的链表。 注意进位和最后的补位
     * */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化链表, 最后取下一个节点返回, 也可以在放入节点时判断是否为null
        ListNode node = new ListNode(0);
        ListNode t = node;
        int m = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int i = n1 + n2 + m;
            m = i / 10;
            t.next = new ListNode(i % 10);
            t = t.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (m == 1) {
            t.next = new ListNode(m);
        }
        return node.next;
    }
}
