package archive.solution_old.probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class MinStack {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     * */
    public static void main(String[] args) {
        MinStackObj minStackObj = new MinStackObj();
        minStackObj.push(3);
        minStackObj.push(7);
        minStackObj.push(2);
        minStackObj.push(1);
        minStackObj.push(9);
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.getMin());
        minStackObj.pop();
        System.out.println(minStackObj.getMin());
    }

    public static class MinStackObj {
        Stack<Integer> list;
        Stack<Integer> min;

        MinStackObj() {
            list = new Stack<>();
            min = new Stack<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            min.push(Math.min(min.peek(), x));
            list.push(x);
        }

        public void pop() {
            if (!list.isEmpty()) {
                list.pop();
                min.pop();
            }
        }

        public int top() {
            return list.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
