package solution_old.offer.solution_0009;

import java.util.Stack;

/**
 * @author shuai.yang
 */
class CoQueueObj {
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    CoQueueObj() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    void appendTail(int value) {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(value);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    int deleteHead() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop();
    }
}
