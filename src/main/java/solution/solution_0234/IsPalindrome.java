package solution.solution_0234;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class IsPalindrome {
    /**
     * 请判断一个链表是否为回文链表。
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
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome1(l1));
    }

    /**
     * 利用栈将链表所有值放入栈中
     * 栈会优先弹出最后一个值
     * 即栈保存了倒序的链表值
     * 循环弹栈比较即可
     * */
    private static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 递归
     * 当递归走到最后一层时, 即是最后一个节点.之后回归时会从后向前回归
     * 将原链表保存下来, 和递归开始回归时进行比较
     * */
    private ListNode copy = null;
    private boolean isPalindrome = true;
    private boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return this.isPalindrome;
        }
        this.copy = head;
        helper(head);
        return this.isPalindrome;
    }
    private void helper(ListNode head) {
        if (head != null) {
            helper(head.next);
            if (this.copy.val != head.val) {
                this.isPalindrome = false;
            }
            this.copy = this.copy.next;
        }
    }
}
