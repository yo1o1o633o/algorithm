package solution_0707;

/**
 * @author shuai.yang
 */
public class MyLinkedList {
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
