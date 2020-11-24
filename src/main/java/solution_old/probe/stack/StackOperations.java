package solution_old.probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class StackOperations {
    /**
     * 栈基本操作
     * */
    public static void main(String[] args) {
        // 创建栈
        Stack<Integer> stack = new Stack<>();
        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 获取栈顶
        System.out.println(stack.peek());
        // 弹出栈顶,并返回
        System.out.println(stack.pop());
        // 判断栈是否空
        System.out.println(stack.isEmpty());
    }
}
