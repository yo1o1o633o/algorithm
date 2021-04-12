package archive.solution_old.probe.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class MyStack {
    /**
     * 实现栈
     * */
    public static void main(String[] args) {
        StackObj stackObj = new StackObj();
        stackObj.push(3);
        stackObj.push(4);
        stackObj.push(5);
        while (!stackObj.isEmpty()) {
            System.out.println(stackObj.top());
            stackObj.pop();
        }
    }

    public static class StackObj {
        List<Integer> list;
        StackObj() {
            list = new ArrayList<>();
        }
        public void push(int value) {
            list.add(value);
        }
        public boolean isEmpty() {
            return list.isEmpty();
        }
        public boolean pop() {
            if (isEmpty()) {
                return false;
            }
            list.remove(list.size() - 1);
            return true;
        }
        public int top() {
            return list.get(list.size() - 1);
        }
    }
}
