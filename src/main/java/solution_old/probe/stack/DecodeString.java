package solution_old.probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class DecodeString {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * */
    public static void main(String[] args) {
        String s = "12[ley]";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {
        String t = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder c = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '[') {
                        break;
                    }
                    c.append(pop);
                }
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty()) {
                    Character pop = stack.peek();
                    if (!Character.isDigit(pop)) {
                        break;
                    }
                    num.insert(0, pop);
                    stack.pop();
                }
                if (!"".equals(num.toString())) {
                    int nums = Integer.parseInt(num.toString());
                    for (int j = 0; j < nums; j++) {
                        for (int k = c.length() - 1; k >= 0; k--) {
                            stack.push(c.charAt(k));
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            t = stack.pop() + t;
        }
        return t;
    }
}