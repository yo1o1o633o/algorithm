package probe.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class NumSquares {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * */
    public static void main(String[] args) {
        int n = 4;
        System.out.println(numSquares(n));
    }

    /**
     * 循环开方, 开方后两种情况一种是1补全 一种是可以整除. 即返回
     * */
    private static int numSquares(int n) {
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer num = queue.poll();
                if (num != null) {
                    int sqrt = (int) Math.sqrt(num);
                    if (num == 1 || sqrt * sqrt == num) {
                        return step;
                    }
                    for (int j = 1; j <= sqrt; j++) {
                        queue.add(num - j * j);
                    }
                }
            }
        }
        return -1;
    }
}
