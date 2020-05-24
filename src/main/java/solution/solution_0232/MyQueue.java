package solution.solution_0232;

import java.util.Stack;

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
        MyQueue1 obj = new MyQueue1();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    /**
     * 没啥好说的
     * 两个栈
     * 一个正序一个倒序
     * */
    public static class MyQueue1 {
        Stack<Integer> stack;
        Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue1() {
            stack = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
            stack2.add(0, x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            stack.remove(0);
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
