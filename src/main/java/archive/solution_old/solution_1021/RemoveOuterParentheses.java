package archive.solution_old.solution_1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shuai.yang
 */
public class RemoveOuterParentheses {
    /**
     * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     *
     * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     *
     * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     *
     * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
     * */
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses2(s));
    }

    /**
     * 使用栈.匹配成对括号. 栈为空时为一个原语（primitive）.放入列表.
     * 循环列表拼接处理
     * */
    private static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(s.substring(c, i + 1));
                c = i + 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (String a : result) {
            res.append(a, 1, a.length() - 1);
        }
        return res.toString();
    }

    /**
     * 维护一个下标值. 当碰到右括号减一. 左括号+1
     * 大于1时就拼接字串
     * */
    private static String removeOuterParentheses2(String s) {
        StringBuilder res = new StringBuilder();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                level--;
            }
            if (level >= 1) {
                res.append(s.charAt(i));
            }
            if (s.charAt(i) == '(') {
                level++;
            }
        }
        return res.toString();
    }
}
