package solution.solution_0876;

import entity.ListNode;
import utils.ListNodeUtils;

public class MiddleNode {
    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     * */
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
        ListNodeUtils.printList(middleNode(l1));
        ListNodeUtils.printList(middleNode1(l1));
    }

    /**
     * 快慢指针。当快指针走到结尾时。 慢指针就是中间节点
     * 注意：链表赋值不会改变原来的链表， 但是给next赋值会改变原来的链表
     * 循环里listNode = listNode.next.next;为跳一个节点。同时head的值没有变化
     * 如果写出listNode.next = listNode.next.next;  head也会改变
     * */
    private static ListNode middleNode(ListNode head) {
        ListNode listNode = head;
        ListNode lower = head;
        while (listNode != null && listNode.next != null) {
            listNode = listNode.next.next;
            lower = lower.next;
        }
        return lower;
    }

    /**
     * 补充单指针
     * 先统计节点数
     * 再根据节点数拿到返回值
     * */
    private static ListNode middleNode1(ListNode head) {
        ListNode listNode = head;
        int num = 0;
        while (listNode != null) {
            listNode = listNode.next;
            num++;
        }
        listNode = head;
        int k = 0;
        while (k < num / 2) {
            listNode = listNode.next;
            k++;
        }
        return listNode;
    }
}
