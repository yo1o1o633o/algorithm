package probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class IsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * */
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    /**
     * 使用栈. 匹配就弹栈.
     * */
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char c = stack.peek();
                if (c == '(' && s.charAt(i) == ')') {
                    stack.pop();
                    continue;
                }
                if (c == '[' && s.charAt(i) == ']') {
                    stack.pop();
                    continue;
                }
                if (c == '{' && s.charAt(i) == '}') {
                    stack.pop();
                    continue;
                }
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
