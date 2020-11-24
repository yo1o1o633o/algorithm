package solution_old.solution_1441;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuai.yang
 */
public class BuildArray {
    /**
     * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
     *
     * 请使用下述操作来构建目标数组 target ：
     *
     * Push：从 list 中读取一个新元素， 并将其推入数组中。
     * Pop：删除数组中的最后一个元素。
     * 如果目标数组构建完成，就停止读取更多元素。
     * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
     *
     * 请返回构建目标数组所用的操作序列。
     *
     * 题目数据保证答案是唯一的。
     * */
    public static void main(String[] args) {
        int[] target = {1,3};
        int n = 5;
        System.out.println(buildArray(target, n));
        System.out.println(buildArray2(target, n));
    }

    /**
     * 维护两个栈, 比较栈顶. 相同就是Push 不同就是Push和Pop
     * */
    private static List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            stack.push(i);
        }
        Stack<Integer> stack1 = new Stack<>();
        for (int i = target.length - 1; i >= 0; i--) {
            stack1.push(target[i]);
        }
        List<String> res = new ArrayList<>();
        while (!stack1.isEmpty()) {
            if (stack.peek().equals(stack1.peek())) {
                res.add("Push");
                stack.pop();
                stack1.pop();
            } else {
                res.add("Push");
                res.add("Pop");
                stack.pop();
            }
        }
        return res;
    }

    /**
     * 双指针
     * */
    private static List<String> buildArray2(int[] target, int n) {
        int i = 0;
        int j = 1;
        List<String> res = new ArrayList<>();
        while (i < target.length) {
            if (target[i] == j) {
                res.add("Push");
                j++;
                i++;
            } else {
                res.add("Push");
                res.add("Pop");
                j++;
            }
        }
        return res;
    }
}
