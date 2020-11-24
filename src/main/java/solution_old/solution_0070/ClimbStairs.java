package solution_old.solution_0070;

import java.util.HashMap;

/**
 * @author Yang
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 37;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n, new HashMap<>()));
        System.out.println(climbStairs4(n));
        System.out.println(climbStairs5(n));
        System.out.println(climbStairs6(n));
    }

    /**
     * 分开计算, 递归计算可能性.  执行超时......
     * 即求出迈2步的可能性.
     * */
    private static int climbStairs(int n) {
        int sum = 1;
        // 只有1次迈两步的
        int climb2 = n - 1;
        // 最多可以迈几次2步
        int num = n / 2;
        for (int i = 2; i <= num; i++) {
            sum += f(i, n - 2 * i);
        }
        return sum + climb2;
    }
    private static int f(int m, int n){
        if (m == 0 || n == 0) {
            return 1;
        }
        return f(m-1, n) + f(m,n-1);
    }


    /**
     * 动态规划
     * 拆解问题.  问题分析.如果是求10个台阶的总可能性
     * 那么到达第10阶只有两种走法, 1是从8迈到10, 2是从9迈到10
     * 也就是说8阶和9阶的和就是10阶的可能性数量
     * 即将问题逐渐向下简化, 最终会到达
     * 3阶是1阶和2阶的总和
     *
     * 解法: 递归取值, 每次要求的值n即是 n-1和n-2的和
     * 最优子结构: 当n = 10时  F(9) + F(8)
     * 边界: 当F(1) + F(2)时已经到底, 无法再拆解. 即称为边界
     * 状态转移公式: F(n - 1) + F(n - 2)
     * 依然无法在力扣执行, 时间超限
     * */
    private static int climbStairs2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    /**
     * 动态规划
     * 问题分析: 上述的递归归总为一个二叉树形式. 而树的节点有些计算是相同的.
     * 为了避免重复计算调用递归, 可以将结果进行缓存
     * 即: 备忘录算法
     * */
    private static int climbStairs3(int n, HashMap<Integer, Integer> maps) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        if (maps.containsKey(n)) {
            return maps.get(n);
        } else {
            int value = climbStairs3(n - 1, maps) + climbStairs3(n - 2, maps);
            maps.put(n, value);
            return value;
        }
    }


    /**
     * 动态规划
     * 既然已知1阶是1  2阶是2
     * 3阶等于1阶+2阶
     * 4阶等于2阶+3阶
     * 那么就无需递归计算, 只要循环对前两个数进行加和计算即可
     * */
    private static int climbStairs4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        // 从3开始计算, 1和2直接都返回了.从3开始一直到要求的台阶数
        for (int i = 3; i <= n; i++) {
            // 只临时保存前两个数的值.用于下次循环的计算
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 官方 : Binets方法
     * 它使用矩阵乘法来得到第 n 个斐波那契数
     * 无法理解. 大体意思是定义一个双层结构, 然后循环向里填充数据进行计算.
     * */
    private static int climbStairs5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    private static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }


    /**
     * 官方 : 斐波那契公式
     * 套用公式计算
     * */
    private static int climbStairs6(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fib / sqrt5);
    }
}
