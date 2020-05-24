package utils;

import entity.ListNode;

public class ListNodeUtils {
    public static void printList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }
}
