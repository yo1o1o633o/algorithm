package archive.solution_old.solution_0021;

/**
 * @author Yang
 */
public class MergeTwoLists {
    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(7);

        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(6);
        listNode2.next.next.next = new ListNode(8);

//        System.out.println(mergeTwoLists(listNode1, listNode2));
        System.out.println(mergeTwoLists2(listNode1, listNode2));
    }

    /**
     * 递归
     * 1,4,7
     * 3,5,6,8
     * 判断 1<3 那么1的对象next接受的就是4和3比较的结果
     * 4>3那么3的next接受的就是4和5比较的结果
     * 4<5那么4接受5和7的比较结果
     * 7>5那么5(l2.next)接受7和6比较结果
     * 7>6那么6l2.next)接受7和8的比较结果
     * 7<8那么7(l1.next)接受8和null的比较结果
     * 递归的回归
     * 8和null返回8
     * 7.next = 8
     * 6.next = 7.next = 8
     *
     * 即递归比较选出val小的一个接受下一次递归的返回值
     * 最终递归回归时, 就会从大到小回归
     * */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     * 1,4,7
     * 3,5,6,8
     * 循环判断两个链表的值, 将小的拼到新建的链表后边
     * 当其中一个链表已经没有下一个的时候. 那么另一个链表剩下的就无需比较, 直接拼到新建链表后边即可(两个链表都是升序的)
     * 1和3比较
     * 1<3  per = -1,1,4,7   per后移一位1,4,7  l1后移一位  4,7
     * 4>3  per = 1,3,5,6,8 即给per.next赋值   l2后移一位
     *
     * -1
     * -1,[1,4,7]A
     * 1,4,7
     * 1,[3,5,6,8]B
     * 1,3,[4,7]A
     * 1,3,4,[5,6,8]B
     * 1,3,4,[5,6,8]B
     * 1,3,4,5,6,[7]A
     * 1,3,4,5,6,7,[8]B
     * 注意不是一个元素一个元素取, 每次取出的都是一个后续链表.
     * 所以要依靠next向后位移来循环赋值顶替掉 即[]部分
     * */
    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode(-1);
        ListNode per = listNode;
        // 当l1和l2都没有到最后一个的时候, 继续循环
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                // l1大于l2的值, l2向后移一位
                per.next = l2;
                l2 = l2.next;
            } else {
                per.next = l1;
                // l1小于l2的值, l1向后移一位
                l1 = l1.next;
            }
            per = per.next;
        }
        // 判断两个链表最后剩下的, 如果有即链接到最后
        per.next = l1 == null ? l2 : l1;
        // 返回第二个开始的链表. 即不返回初始化的-1链表值
        return listNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
