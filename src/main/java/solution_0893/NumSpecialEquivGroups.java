package solution_0893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumSpecialEquivGroups {
    /**
     * 你将得到一个字符串数组 A。
     *
     * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
     *
     * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
     *
     * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
     *
     * 返回 A 中特殊等价字符串组的数量。
     *
     *
     * 题目翻译成人话
     *
     * 有一个字符串数组。 每个字符串交换奇数位或者偶数位能找到另一个匹配的字符串就算一组
     * 例如
     * ["aeadaef", "adaeaef"]
     * 奇数位
     * aaaf     aaaf
     * 偶数位
     * ede  dee
     * 偶数位组成相同位置不同， 可以经过交换得到相同的
     * 即是一组
     * */
    public static void main(String[] args) {
        String[] str = {"abc", "acb", "bac", "bca", "cab", "cba"};
        System.out.println(numSpecialEquivGroups(str));
    }


    /**
     * 取出奇数和偶数位的字符
     * 拼接成排列好的字符串
     * 利用set去重
     * */
    private static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
