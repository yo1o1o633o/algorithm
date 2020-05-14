package solution_1047;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class RemoveDuplicates {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * */
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    /**
     * 利用栈, 循环和栈顶比较. 如果相同就移除栈顶元素. 剩下的就是结果
     * */
    private static String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
