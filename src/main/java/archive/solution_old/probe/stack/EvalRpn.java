package archive.solution_old.probe.stack;

import java.util.Stack;

/**
 * @author shuai.yang
 */
public class EvalRpn {
    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 说明：
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     *
     * 逆波兰表达式：
     *
     * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
     *
     * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
     * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
     * 逆波兰表达式主要有以下两个优点：
     *
     * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
     * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
     * */
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRpn(tokens));
    }

    /**
     * 碰到符号就弹出两个进行计算, 并把结果放回队列
     * 注意运算顺序
     * */
    private static int evalRpn(String[] tokens) {
        Stack<String> strings = new Stack<>();
        int a;
        int b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = Integer.parseInt(strings.pop());
                    b = Integer.parseInt(strings.pop());
                    strings.push(b + a + "");
                    break;
                case "-":
                    a = Integer.parseInt(strings.pop());
                    b = Integer.parseInt(strings.pop());
                    strings.push(b - a + "");
                    break;
                case "*":
                    a = Integer.parseInt(strings.pop());
                    b = Integer.parseInt(strings.pop());
                    strings.push(b * a + "");
                    break;
                case "/":
                    a = Integer.parseInt(strings.pop());
                    b = Integer.parseInt(strings.pop());
                    strings.push(b / a + "");
                    break;
                default:
                    strings.push(token);
            }
        }
        return Integer.parseInt(strings.pop());
    }
}
