package archive.solution_old.offer.solution_0064;

/**
 * @author shuai.yang
 */
public class SumNums {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * */
    public static void main(String[] args) {
        int n = 100;
        System.out.println(sumNums(n));
        System.out.println(sumNums1(n));
    }

    /**
     * 递归相加. 递归出口判断不能使用if 换成&&逻辑判断
     * */
    private static int sumNums(int n) {
        boolean f = n > 0 && (n += sumNums(n - 1))> 0;
        return n;
    }

    /**
     * 俄罗斯农民乘法
     *
     * 即: 当两个数相乘的时候.
     * 将第一个数*2  第二个数除2  最后的结果不会改变
     * 那么一直这么运算下去. 当第二个数为1的时候. 第一个数就是最终结果
     * 第二个数如果是奇数, 那么就跳过这一行
     * 35 * 12
     * 70 * 6
     * 140 * 3
     * 280 + 140 * 1
     * 420 * 1
     *
     * 如果第二个数m迭代时是奇数  2 * n + n       (m - 1) / 2
     * 如果m是偶数    2 * n   m / 2
     * */
    private static int sumNums1(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }
}
