package archive.solution_old.solution_0020;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Yang
 */
public class ValidParenthesis {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * () {} [] (()) {{}}  {[]}  {{[[()]]}}  {{[({{}})]}}{}  1123113211
     * */
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        System.out.println(isValid2(s));
    }

    /**
     * 思路 , 必然是偶数个 , 不然就是不满足的
     * 根据分析  要判断的括号串的子串也是要都满足条件的如 {{[({{}})]}}{}    {{[({{}})]}}和{}都是满足条件的
     * 那么可以定义一个有序结构. 向这个结构依次添加字符. 当要添加的是前一个的对应字符, 那么就删掉这两个. 否则就继续添加. 最后判断这个结构, 如果还有留存就是无效的
     * 这个结构在这个方法中用栈结构来实现
     * */
    private static boolean isValid(String s) {
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        if ("".equals(s)) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek().equals(maps.get(s.charAt(i)))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }


    private static boolean isValid2(String s) {
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (maps.containsKey(c)) {
                // 如果是右括号同时栈是空的 那么无效串, 否则弹出栈顶
                char top = stack.empty() ? '#' : stack.pop();
                // 判断右括号是否和栈顶的左括号是一类的. 不是一类的就是无效串
                if (top != maps.get(c)) {
                    return false;
                }
            } else {
                // 左括号, 推入栈顶
                stack.push(c);
            }
        }
        return stack.empty();
    }
}
