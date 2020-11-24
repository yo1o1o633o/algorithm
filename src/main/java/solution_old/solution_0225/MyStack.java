package solution_old.solution_0225;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /**
     * 使用队列实现栈的下列操作：
     *
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * 注意:
     *
     * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
     * */
    public static void main(String[] args) {
        MyStack1 obj = new MyStack1();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_3);
        System.out.println(param_2);
        System.out.println(param_4);

        MyStack2 obj2 = new MyStack2();
        obj.push(1);
        obj.push(2);
        int param_7 = obj.top();
        int param_5 = obj.pop();
        boolean param_6 = obj.empty();
        System.out.println(param_7);
        System.out.println(param_5);
        System.out.println(param_6);
    }

    /**
     * 双端队列。 ArrayDeque非线程安全。性能高于Stack栈。 底层为可变数组。 不支持null
     * */
    public static class MyStack1 {
        private ArrayDeque<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack1() {
            queue = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.removeLast();
        }

        /** Get the top element. */
        public int top() {
            if (!queue.isEmpty()) {
                return queue.peekLast();
            }
            throw new NullPointerException();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static class MyStack2 {
        private Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack2() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            // 维持的是倒序的列表
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element.
         *  链表的特性， poll会移除第一个元素， 而这里元素是倒序排列的。所以第一个元素就是栈顶元素。 top也是同理
         * */
        public int pop() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
            throw new NullPointerException();
        }

        /** Get the top element. */
        public int top() {
            if (!queue.isEmpty()) {
                return queue.peek();
            }
            throw new NullPointerException();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
