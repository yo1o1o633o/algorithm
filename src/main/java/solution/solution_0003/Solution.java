package solution.solution_0003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * */
public class Solution {
    public static void main(String[] args) {
        String s = "anviaj";
        System.out.println(lengthOfLongestSubstringWithWindow(s));
    }

    /**
     * 滑动窗口
     * 两层循环, 每次向后推找到左指针起始的最长不相同字符.
     * 最后计算最大值
     * */
    private static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            List<Character> l = new ArrayList<>();
            int j = i;
            while (j < chars.length) {
                if (!l.contains(chars[j])) {
                    l.add(chars[j]);
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, l.size());
            i++;
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * 用Hash保存字符和下标. 当右指针碰到已经存在的字符时, 则计算更新左指针.
     * 从左到右进行处理, 则遇到相同的字符会将索引位大的更新到Map中
     *
     * 1. 当未遇到相同字符时, left一直不变 右指针一直变大. 更新最大长度即可
     * 2. 当遇到相同字符时, 如 abca. 则Map中保存的时 a->0,b->1,c->2 此时map.get(a)=0. 取出+1就是b的索引1. left右移到1
     * 3. 当遇到相同字符时, 如 abb. 则Map中保存的是 a->0,b->1. 此时map.get(b)=1 取出+1就是2. left右移到2
     * left = Math.max(left, map.get(chars[i]) + 1);
     */
    private static int lengthOfLongestSubstringWithWindow(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            // i为右指针, left为左指针. 那么当前的长度就是 i - left + 1
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
