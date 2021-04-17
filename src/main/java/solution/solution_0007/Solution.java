package solution.solution_0007;

/**
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * */
public class Solution {
    public static void main(String[] args) {
        int x = -214748;
        System.out.println(reverseWithString(x));
        System.out.println(reverseWithMathematics(x));
    }

    /**
     * 数学计算，循环进行模10计算取最后一位
     * 注意反转后的数据会超出2的31次方数，在下次计算前判断乘以10后会不会溢出， 溢出直接返回0
     * */
    private static int reverseWithMathematics(int x) {
        long res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int i = x % 10;
            res = res * 10 + i;
            x = x / 10;
        }
        return (int)res;
    }

    /**
     * 转成字符串循环取值， 需要转换数据类型
     * */
    private static int reverseWithString(int x) {
        boolean is = false;
        if (x < 0) {
            x = x * -1;
            is = true;
        }
        int res = 0;
        String[] ix = String.valueOf(x).split("");
        for (int i = ix.length - 1; i >= 0; i--) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + Integer.parseInt(ix[i]);
        }
        if (is) {
            res = res * -1;
        }
        return res;
    }
}
