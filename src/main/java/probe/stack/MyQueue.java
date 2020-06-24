package probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class MyQueue {
    /**
     * 使用栈实现队列的下列操作：
     *
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * */
    public static void main(String[] args) {
        MyQueueObj queue = new MyQueueObj();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    public static class MyQueueObj {
        Stack<Integer> stack;
        Stack<Integer> reverseStack;
        /**
         * Initialize your data structure here.
         */
        MyQueueObj() {
            stack = new Stack<>();
            reverseStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         * 入栈时利用另一个栈将push进来的数据放在栈底
         */
        public void push(int x) {
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
            stack.push(x);
            while (!reverseStack.isEmpty()) {
                stack.push(reverseStack.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}