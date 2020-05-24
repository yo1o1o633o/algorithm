package solution.solution_0707;

/**
 * @author shuai.yang
 */
public class MyLinkedList2 {
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
        MyLinkedList2Obj linkedList = new MyLinkedList2Obj();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }

    /**
     * 双向链
     * */
    static class Node {
        int val;
        Node next;
        Node prev;
        Node(int x) {
            this.val = x;
        }
    }

    static class MyLinkedList2Obj {
        int size;
        Node head;
        Node tail;

        MyLinkedList2Obj() {
            size = 0;
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node curr = head;
            if (index + 1 < size - index) {
                for (int i = 0; i < index + 1; i++) {
                    curr = curr.next;
                }
            } else {
                curr = tail;
                for (int i = 0; i < size - index; i++) {
                    curr = curr.prev;
                }
            }
            return curr.val;
        }
        public void addAtHead(int val) {
            // 有个初始化节点0. 所以在头部加一个节点, 这里处理实际是第一个节点后插入
            Node pred = head;
            Node succ = head.next;
            size++;
            Node add = new Node(val);
            add.prev = pred;
            add.next = succ;
            pred.next = add;
            succ.prev = add;
        }
        public void addAtTail(int val) {
            Node succ = tail;
            Node pred = tail.prev;

            size++;
            Node add = new Node(val);
            add.prev = pred;
            add.next = succ;
            pred.next = add;
            succ.prev = add;
        }
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            Node pred ,succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index; i++) {
                    succ = succ.prev;
                }
                pred = succ.prev;
            }
            size++;
            Node add = new Node(val);
            add.prev = pred;
            add.next = succ;
            succ.prev = add;
            pred.next = add;
        }
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node pred, succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index - 1; i++) {
                    succ = succ.prev;
                }
                pred = succ.prev.prev;
            }
            size--;
            pred.next = succ;
            succ.prev = pred;
        }
    }
}
