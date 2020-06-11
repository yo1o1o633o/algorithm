package solution.solution_0739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author shuai.yang
 */
public class DailyTemperatures {
    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * */
    public static void main(String[] args) {
        int[] t = {77,77,77,77,73,41,75,34,41,77};
        System.out.println(Arrays.toString(dailyTemperatures(t)));
        System.out.println(Arrays.toString(dailyTemperatures1(t)));
        System.out.println(Arrays.toString(dailyTemperatures2(t)));
    }

    /**
     * 循环呗
     * */
    private static int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            int index = 0;
            int temp = 0;
            for (int j = i + 1; j < t.length; j++) {
                temp++;
                if (t[j] > t[i]) {
                    index = temp;
                    break;
                }
            }
            res[i] = index;
        }
        return res;
    }

    /**
     * 改成栈, 但是未解决跨天的天数取值
     * */
    private static int[] dailyTemperatures1(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = t.length - 1; i >= 0; i--) {
            int top = stack.peek();
            if (t[i] < top) {
                res[i] = 1;
            } else {
                int index = 0;
                int k = 0;
                for (int j = i + 1; j < t.length; j++) {
                    index++;
                    if (t[j] > t[i]) {
                        k = index;
                        break;
                    }
                }
                res[i] = k;
            }
            stack.push(t[i]);
        }
        return res;
    }

    /**
     * 从前向后入栈判断
     * */
    private static int[] dailyTemperatures2(int[] t) {
        int[] res = new int[t.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < t.length; i++) {
            int temp = t[i];
            while (!stack.isEmpty() && t[stack.peek()] < temp) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
