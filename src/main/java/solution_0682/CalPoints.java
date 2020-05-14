package solution_0682;

import java.util.Stack;

public class CalPoints {
    /**
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     *
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     * */
    public static void main(String[] args) {
        String[] s = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(s));
    }

    /**
     * 循环判断, 对非数字进行判断, 求得对应的值放入栈内.
     * 栈内只保存每轮得分数字
     * */
    private static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                Integer l1 = stack.pop();
                Integer l2 = stack.peek();
                stack.push(l1);
                stack.push(l1 + l2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else {
                stack.add(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
