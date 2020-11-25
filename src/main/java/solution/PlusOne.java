package solution;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author shuai.yang
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * 计算. 从后向前处理.
     * 不能转成整数, 会溢出
     * 注意全部为9时的数组扩容
     * */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 进行++操作
            digits[i]++;
            // 如果满10则归0
            digits[i] %= 10;
            // 当前计算未满10, 则忽略后续计算, 直接返回即可
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 如果都是9, 那么会得到1后边全是0的数组.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
