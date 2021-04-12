package archive.solution_old.probe.queue;

/**
 * @author shuai.yang
 */
public class MyCircularQueue {
    /**
     * 实现环形队列
     * */
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.rear());
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.front());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
    }

    public static class CircularQueue {
        private int[] queue;
        private int size;
        private int head;
        private int tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        CircularQueue(int k) {
            queue = new int[k];
            size = k;
            head = -1;
            tail = -1;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                head = 0;
            }
            tail = (tail + 1) % size;
            queue[tail] = value;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = (head + 1) % size;
            return true;
        }

        /** Get the front item from the queue. */
        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        /** Get the last item from the queue. */
        public int rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == -1;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return ((tail + 1) % size) == head;
        }
    }
}
