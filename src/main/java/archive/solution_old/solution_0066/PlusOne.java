package archive.solution_old.solution_0066;

import java.util.Arrays;

/**
 * @author Yang
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 题目理解:
     * 即给了一个整型数组, 数组的每个元素都是0~9之间的. 这个数组就可以组成一个大整数, 对这个数加1 再转数组
     * 例: [3,4,5,7]  -> 3458+1=3459  -> [3,4,5,8]
     * */
    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * 对最后一个元素+1, 然后判断, 如果满10 再对前一个元素操作
     * */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    // 省略. 默认不赋值就是0
                    // for (int j = 1; j < res.length; j++) {
                    //     res[j] = 0;
                    // }
                    return res;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }
}
