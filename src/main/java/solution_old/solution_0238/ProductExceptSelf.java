package solution_old.solution_0238;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class ProductExceptSelf {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * */
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 9};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
        System.out.println(Arrays.toString(productExceptSelf3(nums)));
    }

    /**
     * 基本的暴力循环法
     * */
    private static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    n *= nums[j];
                }
            }
            res[i] = n;
        }
        return res;
    }

    /**
     * 使用除法. 先计算总的乘积, 再依次除当前得数组元素.
     * 注意 如果有2个以上得0 那么返回得数组就全是0
     * 如果有1个0 那么除了这个0以外 其他元素都是0
     * 24 = 2*3*4
     * 12 = 1*3*4
     * 8  = 1*2*4
     * 6  = 1*2*3
     * */
    private static int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int n = 1;
        int f = 0;
        for (int num : nums) {
            if (num != 0) {
                n *= num;
            } else {
                if (f > 0) {
                    return res;
                }
                f++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (f == 1) {
                if (nums[i] != 0) {
                    res[i] = 0;
                } else {
                    res[i] = n;
                }
            } else {
                res[i] = n / nums[i];
            }
        }
        return res;
    }

    /**
     * 3次循环.
     * 第一次循环取出前缀乘积
     * 第二次循环取出后缀乘积
     * 最后求总得乘积
     * 1, 2, 3, 4, 5
     * 3 = 1*2  *  4*5
     * 1*2前缀  4*5后缀
     * 如上分别求出每个索引位得前后缀即可计算结果  O3
     * */
    private static int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = nums[i] * left[i];
        }
        right[right.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = nums[i] * right[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < left.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * O1 空间复杂度
     * */
    private static int[] productExceptSelf3(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            res[i + 1] = nums[i] * res[i];
        }
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            r *= nums[i];
        }
        return res;
    }
}
