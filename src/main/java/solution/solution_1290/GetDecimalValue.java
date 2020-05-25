package solution.solution_1290;

import entity.ListNode;

/**
 * @author shuai.yang
 */
public class GetDecimalValue {
    /**
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     *
     * 请你返回该链表所表示数字的 十进制值 。
     * */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(0);
        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1);
        ListNode l10 = new ListNode(0);
        ListNode l11 = new ListNode(0);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;

        System.out.println(getDecimalValue(l1));
        System.out.println(getDecimalValue1(l1));
    }

    /**
     * 链表每向后移动一个节点. 原来的值就是向左位移一位. 再加上当前值
     * */
    private static int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }

    /**
     * 利用二进制转换公式
     * */
    private static int getDecimalValue1(ListNode head) {
        int num = 0;
        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }
}
