package probe.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class MyQueue {
    /**
     * 用数组实现一个队列
     * */
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(3);
        queue.add(4);
        queue.isEmpty();
        queue.pop();
        queue.size();
        queue.add(4);
        System.out.println(queue.start);
    }

    public static class Queue {
        private List<Integer> list;
        private int start;

        Queue() {
            list = new ArrayList<>();
            start = 0;
        }

        public void add(int x) {
            list.add(x);
        }

        public boolean pop() {
            if (isEmpty()) {
                return false;
            }
            start++;
            return true;
        }

        public int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return start >= list.size();
        }
    }
}
