package solution.solution_0707;

/**
 * @author shuai.yang
 */
public class MyLinkedList {
    /**
     * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
     *
     * 在链表类中实现这些功能：
     *
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     * */
    public static void main(String[] args) {
        MyLinkedListObj linkedList = new MyLinkedListObj();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }


    /**
     * 单向链
     * */
    static class LinkedNode {
        int val;
        LinkedNode next;
        LinkedNode(int val) {
            this.val = val;
        }
    }

    public static class MyLinkedListObj {
        int size;
        LinkedNode head;

        private MyLinkedListObj() {
            size = 0;
            head = new LinkedNode(0);
        }

        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            }
            LinkedNode curr = head;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        private void addAtHead(int val) {
            addAtIndex(0, val);
        }

        private void addAtTail(int val) {
            addAtIndex(size, val);
        }

        private void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ++size;
            LinkedNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            LinkedNode add = new LinkedNode(val);
            add.next = temp.next;
            temp.next = add;
        }

        private void deleteAtIndex(int index) {
            if (index > size || index < 0) {
                return;
            }
            size--;
            LinkedNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}
