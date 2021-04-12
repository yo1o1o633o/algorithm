package archive.solution_old.probe.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class MyStack {
    /**
     * 使用队列实现栈的下列操作：
     *
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * */
    public static void main(String[] args) {
        MyStackObj obj = new MyStackObj();
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }

    private static class MyStackObj {
        Queue<Integer> queue;
        Queue<Integer> helpQueue;

        /**
         * Initialize your data structure here.
         */
        MyStackObj() {
            queue = new LinkedList<>();
            helpQueue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            while (!queue.isEmpty()) {
                helpQueue.add(queue.poll());
            }
            queue.add(x);
            while (!helpQueue.isEmpty()) {
                queue.add(helpQueue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
            throw new NullPointerException();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (!queue.isEmpty()) {
                return queue.peek();
            }
            throw new NullPointerException();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
