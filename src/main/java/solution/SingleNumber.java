package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author shuai.yang
 * */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberWithBit(nums));
        System.out.println(singleNumberWithHash(nums));
    }

    /**
     * 位运算
     * 两个相同的数的异或运算为0 ， 0异或一个数结果还是这个数
     * 所有元素异或运算后结果就是出现一次的元素
     *
     * 异或运算有以下三个性质。
     *
     * 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
     * 任何数和其自身做异或运算，结果是 00，即 a⊕a=0 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     * */
    private static int singleNumberWithBit(int[] nums) {
        // 加这个在leetCode提升到99%
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    /**
     * 已知所有元素都是成对的， 只有1个单个的
     * 使用一个hash表， 当表中已存在这个元素， 那么移除他
     * 最终hash表中只剩下出现一次的元素
     * */
    private static int singleNumberWithHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
                continue;
            }
            set.add(n);
        }
        return set.iterator().next();
    }
}
