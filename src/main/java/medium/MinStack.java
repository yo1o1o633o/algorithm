package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     * */
    public static void main(String[] args) {
        MinStack1 obj = new MinStack1();
        obj.push(15);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);

        MinStack2 obj2 = new MinStack2();
        obj2.push(-2);
        obj2.push(0);
        obj2.push(-3);
        int param_6 = obj2.getMin();
        System.out.println(param_6);
        obj2.pop();
        int param_5 = obj2.top();
        System.out.println(param_5);
        int param_7 = obj2.getMin();
        System.out.println(param_7);
    }

    private static class MinStack1 {
        private List<Integer> stacks = new ArrayList<>();
        public MinStack1() {

        }
        public void push(int x) {
            stacks.add(x);
        }
        public void pop() {
            stacks.remove(stacks.size() - 1);
        }
        public int top() {
            return stacks.get(stacks.size() - 1);
        }
        public int getMin() {
            int mix = Integer.MAX_VALUE;
            for (Integer stack : stacks) {
                mix = Math.min(stack, mix);
            }
            return mix;
        }
    }

    /**
     * 添加辅助线
     * 增加一个辅助栈， 将每次push入栈的值和栈顶比较， 将较小的值放到栈顶
     * 栈顶永远都是最小的元素
     * */
    private static class MinStack2 {
        private Stack<Integer> stacks = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();
        public MinStack2() {
            minStack.push(Integer.MAX_VALUE);
        }
        public void push(int x) {
            minStack.push(Math.min(minStack.peek(), x));
            stacks.push(x);
        }
        public void pop() {
            if (!stacks.isEmpty()) {
                stacks.pop();
                minStack.pop();
            }
        }
        public int top() {
            if (!stacks.isEmpty()) {
                return stacks.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }
}
