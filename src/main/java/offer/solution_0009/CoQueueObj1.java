package offer.solution_0009;

import java.util.Stack;

/**
 * @author shuai.yang
 */
class CoQueueObj1 {
    /**
     * 避免每次添加都倒腾一次
     * */
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;
    private int size;

    CoQueueObj1() {
        stack = new Stack<>();
        tempStack = new Stack<>();
        size = 0;
    }

    void appendTail(int value) {
        stack.push(value);
        size++;
    }

    int deleteHead() {
        if (size == 0) {
            return -1;
        }
        if (tempStack.isEmpty()) {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        size--;
        return tempStack.pop();
    }
}
