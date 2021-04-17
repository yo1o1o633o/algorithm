package solution.solution_0020;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValidWithReplace("()"));
    }

    /**
     * 使用栈，如果是左括号或者匹配不到的右括号， 就压栈
     * 如果是右括号就取出来和栈顶匹配。如果匹配就弹栈
     * */
    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            Character peek = stack.peek();
            char c = chars[i];
            if (c == ')' && peek == '(') {
                stack.pop();
            } else if (c == ']' && peek == '[') {
                stack.pop();
            } else if (c == '}' && peek == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 一种效率很慢， 但是很清奇的思路， 循环字符串替换
     * */
    private static boolean isValidWithReplace(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }
}
