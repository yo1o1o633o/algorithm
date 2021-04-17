package solution.solution_0206;

import entity.ListNode;
import utils.ListNodeUtils;

import java.util.Stack;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 * */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNodeUtils.printList(reverseListWithRecursion(listNode));
    }

    /**
     * 使用栈， 先取出再保存
     * */
    private static ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            temp.next = new ListNode(pop);
            temp = temp.next;
        }
        return res.next;
    }

    /**
     * 使用循环， 每次取出链表头节点， 创建新链表对象， 先把之前的结果赋给他的next。 把赋值后的对象赋值给结果值
     * */
    private static ListNode reverseListWithFor(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            listNode.next = res;
            res = listNode;
            head = head.next;
        }
        return res;
    }

    /**
     * 递归
     * 递归到最后一个节点5， 开始回归处理。
     * 将上一个节点赋给他， 即  5->4->5. 然后将4的下个节点置为null
     * 下一次回归， 即5->4->3->4  然后将3的下个节点置为null
     * 最终返回
     * */
    private static ListNode reverseListWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
