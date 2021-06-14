package offer.offer_006;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        int j = list.size() - 1;
        for (Integer integer : list) {
            res[j] = integer;
            j--;
        }
        return res;
    }

    public static int[] reversePrintWithStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
