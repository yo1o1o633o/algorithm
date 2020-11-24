package solution_old.solution_0032;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class LongestValidParentheses {
    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * TODO 其他解法等后续学习
     * */
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses1(s));
    }

    /**
     * 用栈记录有效的括号
     * */
    private static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    indexStack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
            indexStack.push(i);
        }
        if (indexStack.isEmpty()) {
            return s.length();
        }
        int max = Integer.MIN_VALUE;
        int start = s.length();
        while (!indexStack.isEmpty()) {
            Integer pop = indexStack.pop();
            max = Math.max(start - (pop + 1), max);
            start = pop;
        }
        max = Math.max(start, max);
        return max;
    }

    /**
     * 栈优化
     * */
    private static int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
